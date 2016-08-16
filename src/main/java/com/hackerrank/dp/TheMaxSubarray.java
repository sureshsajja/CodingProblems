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

package com.hackerrank.dp;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh Date :  04/09/15 Version : v1
 */

/**
 * https://www.hackerrank.com/challenges/maxsubarray
 *
 * To find max sum in contiguous sub array
 * ======================================
 * 1. For each element i in the array, maintain currentSum ending at i
 * 2. compare currentSum with maxSum
 * 3. if currentSum is <= 0, reinitialise to 0
 *
 * Non-contiguous sub array sum
 * ============================
 * 1. Add only positive integers to positive Sum.
 * 2. if all arrays elements are negative : get the max element in array to return as max sum
 *
 */
public class TheMaxSubarray {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    public static void solve() throws IOException {

        int T = nextInt();
        for (int t = 0; t < T; t++) {

            int N = nextInt();
            int[] array = new int[N];

            int maxSum = Integer.MIN_VALUE;
            int currentSum = 0;
            int positiveSum = 0;
            int maxElement = Integer.MIN_VALUE;
            for (int n = 0; n < N; n++) {
                array[n] = nextInt();
                currentSum += array[n];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
                if (currentSum < 0) {
                    currentSum = 0;
                }
                if (array[n] > 0) {
                    positiveSum += array[n];
                }
                if (array[n] > maxElement) {
                    maxElement = array[n];
                }
            }

            if (positiveSum == 0) {
                positiveSum = maxElement;
            }

            pw.print(maxSum);
            pw.print(" ");
            pw.println(positiveSum);
        }
    }
}
