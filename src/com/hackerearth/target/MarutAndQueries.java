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
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  19/07/15
 * Version : v1
 */
public class MarutAndQueries {

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

        int N = nextInt();
        int[] A = new int[N];
        int[] sortedA = new int[N];
        for (int n = 0; n < N; n++) {
            int i = nextInt();
            A[n] = i;
            sortedA[n] = i;
        }

        Arrays.sort(sortedA);
        int Q = nextInt();
        for (int q = 0; q < Q; q++) {
            int k = nextInt() - 1;
            int x = nextInt() - 1;

            int a = sortedA[k];
            int b = sortedA[x];
            if (a == b) {
                pw.println(0);
            } else {
                int i = maxIndexBinarySearch(sortedA, k, x, a);
                pw.println(x - i);
            }
        }


        reader.close();
        pw.close();
    }

    public static int maxIndexBinarySearch(int[] array, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((array[mid] == key) && (mid == array.length - 1 || array[mid + 1] > key)) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return -1;
    }
}
