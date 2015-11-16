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

package com.hackerearth.mayeasy15;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/panda-and-maximum-product/
 */
public class PandaAndMaximumProduct {


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
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int N = nextInt();
        List<Long> positives = new ArrayList<>();
        List<Long> negatives = new ArrayList<>();
        StringTokenizer _tokenizer = new StringTokenizer(reader.readLine());
        while(_tokenizer.hasMoreElements()){
          long n =   Long.parseLong(_tokenizer.nextToken());
            if (n < 0) {
                negatives.add(n * -1);
            } else {
                positives.add(n);
            }
        }

        Collections.sort(positives);
        Collections.sort(negatives);

        BigInteger pos = getMaxProductWithTwo(positives);
        BigInteger neg = getMaxProductWithTwo(negatives);

        if (pos.compareTo(neg) == 1) {
            pw.println(pos);
        } else {
            pw.println(neg);
        }

        reader.close();

        pw.close();
    }


    private static BigInteger getMaxProductWithTwo(List<Long> list) {


        if (list.size() > 1) {
            long one = list.get(list.size() - 1);
            long two = list.get(list.size() - 2);
            return BigInteger.valueOf(one).multiply(BigInteger.valueOf(two));
        }
        return BigInteger.ZERO;
    }
}
