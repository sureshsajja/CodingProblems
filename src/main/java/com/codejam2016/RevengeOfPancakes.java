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
 */

package com.codejam2016;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 09/04/16
 * Version : v1
 */
public class RevengeOfPancakes {

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

        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            String s = next();
            pw.println("Case #" + t + ": " + getNumberOfFlips(s));
        }

        reader.close();
        pw.close();

    }


    private static long getNumberOfFlips(String s) {
        char[] array = s.toCharArray();
        return flip(array, s.length() - 1, new HashMap<String, Long>());
    }

    private static long flip(char[] array, int index, Map<String, Long> visited) {

        String key = new String(array);
        while (index >= 0 && array[index] == '+') {
            index--;
        }

        if (index < 0) {
            return 0;
        }

        if (visited.containsKey(key)) {
            return visited.get(key);
        } else {
            visited.put(key, 1L + Integer.MAX_VALUE);
        }

        char[] array1 = new char[array.length];
        char[] array2 = new char[array.length];
        copy(array, index, array1);
        int neg = index;
        while (neg >= 0 && array[neg] == '-') {
            neg--;
        }
        copy(array, neg, array2);

        long result = 1L + min(flip(array1, index, visited), flip(array2, index, visited));
        visited.put(key, result);
        return result;

    }

    private static long min(long i, long j) {
        return i > j ? j : i;
    }

    private static void copy(char[] array, int index, char[] array1) {

        for (int i = index, j = 0; i >= 0; i--, j++) {
            if (array[i] == '-')
                array1[j] = '+';
            else array1[j] = '-';
        }
        System.arraycopy(array, index + 1, array1, index + 1, array.length - (index + 1));
    }
}
