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

package com.hackerearth.easy;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 07/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/find-the-nth-prime/
 */
public class FindTheNthPrime {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static final int MAX = 10000;
    private static int[] primes = new int[1229];


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
        sieve();

        int N = nextInt();
        pw.println(primes[N - 1]);

        reader.close();
        pw.close();
    }


    private static void sieve() {

        BitVector vector = new BitVector(MAX);
        int[] seq = new int[]{2, 4, 2, 4, 6, 2, 6, 4,
                2, 4, 6, 6, 2, 6, 4, 2,
                6, 4, 6, 8, 4, 2, 4, 2,
                4, 8, 6, 4, 6, 2, 4, 6,
                2, 6, 6, 4, 2, 4, 6, 2,
                6, 4, 2, 4, 2, 10, 2, 10};
        int index = 0;
        for (int i = 11; i < Math.sqrt(MAX); i += seq[index++]) {
            if (!vector.isSet(i)) {
                int index2 = index;
                for (int j = i * i; j < MAX; j = j + seq[index2++] * i) {
                    vector.setBit(j);
                    if (index2 == 48) {
                        index2 = 0;
                    }
                }

            }
            if (index == 48) {
                index = 0;
            }

        }


        index = 0;
        int k = 0;
        primes[k++] = 2;
        primes[k++] = 3;
        primes[k++] = 5;
        primes[k++] = 7;
        for (int i = 11; i < MAX; i += seq[index++]) {
            if (!vector.isSet(i)) {
                primes[k++] = i;
            }
            if (index == 48) {
                index = 0;
            }
        }
    }

    private static class BitVector {

        private int[] bitArray;

        public BitVector(long MAX) {
            bitArray = new int[(int) (MAX >> 6) + 1];
        }

        public void setBit(long i) {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            bitArray[index] = (bitArray[index]) | (1 << bit);
        }

        public boolean isSet(long i) {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            return ((bitArray[index]) & (1 << bit)) != 0;
        }
    }
}
