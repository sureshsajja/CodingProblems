/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.hackerearth.target;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  19/07/15
 * Version : v1
 */
public class WillYouBeMyFriend {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int A = nextInt();

        Map<Integer, Long> aFactors = primeFactors(A);

        int N = nextInt();
        int count = 0;
        for (int n = 0; n < N; n++) {
            int i = nextInt();
            Map<Integer, Long> iFactors = primeFactors(i);
            if (compareFactors(aFactors, iFactors)) {
                count++;
            }
        }

        pw.println(count);

        reader.close();
        pw.close();
    }

    private static boolean compareFactors(Map<Integer, Long> afactors, Map<Integer, Long> ifactors) {
        for (Integer ifactor : ifactors.keySet()) {
            if (afactors.containsKey(ifactor)) {
                return true;
            }
        }
        return false;
    }

    private static Map<Integer, Long> primeFactors(int a) {

        Map<Integer, Long> factors = new HashMap<>();

        while (a % 2 == 0) {
            a = a / 2;
            addToMap(factors, 2);
        }

        while (a % 3 == 0) {
            a = a / 3;
            addToMap(factors, 3);
        }

        for (int i = 5; i <= Math.sqrt(a); i += 6) {
            while (a % i == 0) {
                a = a / i;
                addToMap(factors, i);
            }
            while (a % (i + 2) == 0) {
                a = a / (i + 2);
                addToMap(factors, i + 2);
            }
        }
        if (a > 2) {
            addToMap(factors, a);
        }

        return factors;
    }

    private static void addToMap(Map<Integer, Long> factors, int factor) {
        if (factors.containsKey(factor)) {
            factors.put(factor, factors.get(factor) + 1);
        } else {
            factors.put(factor, 1L);
        }
    }
}
