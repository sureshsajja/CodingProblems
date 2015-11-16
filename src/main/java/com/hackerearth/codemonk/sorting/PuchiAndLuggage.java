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

package com.hackerearth.codemonk.sorting;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  12/08/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/code-monk-sorting/algorithm/puchi-and-luggage/
 */
public class PuchiAndLuggage {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static int[] lazy;
    private static int[] tree;

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
        for (int t = 0; t < T; t++) {
            int N = nextInt();
            int[] array = new int[N];
            int[] sortedArray = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = nextInt();
                sortedArray[n] = array[n];
            }
            Arrays.sort(sortedArray);

            int log = (int) Math.ceil(Math.log(N) / Math.log(2));
            int size = 2 * (int) Math.pow(2, log) - 1;
            lazy = new int[size];
            tree = new int[size];
            buildTree(0, 0, N - 1);


            for (int n = 0; n < N; n++) {
                int key = Arrays.binarySearch(sortedArray, array[n]);
                if (key > 0) {
                    pw.print(queryTree(0, 0, N - 1, 0, key - 1));
                } else {
                    pw.print(0);
                }
                updateTree(0, 0, N - 1, key, key, -1);
                pw.print(" ");
            }
            pw.println();
        }


        reader.close();
        pw.close();
    }

    public static void buildTree(int index, int a, int b) {

        if (a > b) {
            return;
        }
        if (a == b) {
            tree[index] = 1;
            return;
        }
        buildTree(2 * index + 1, a, (a + b) / 2);
        buildTree(2 * index + 2, (a + b) / 2 + 1, b);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

    }

    public static void updateTree(int index, int a, int b, int i, int j, int value) {

        if (lazy[index] != 0) {
            tree[index] += (b - a + 1) * lazy[index];
            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }
            lazy[index] = 0;
        }

        if (a > b || a > j || b < i)
            return;

        if (a >= i && b <= j) {
            tree[index] += (b - a + 1) * value;

            if (a != b) {
                lazy[index * 2 + 1] += value;
                lazy[index * 2 + 2] += value;
            }
            return;
        }

        updateTree(index * 2 + 1, a, (a + b) / 2, i, j, value);
        updateTree(index * 2 + 2, (a + b) / 2 + 1, b, i, j, value);
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

    }

    public static long queryTree(int index, int a, int b, int i, int j) {

        if (a > b || a > j || b < i)
            return 0;

        if (lazy[index] != 0) {
            tree[index] += (b - a + 1) * lazy[index];

            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (a >= i && b <= j)
            return tree[index];

        long q1 = queryTree(index * 2 + 1, a, (a + b) / 2, i, j);
        long q2 = queryTree(index * 2 + 2, 1 + (a + b) / 2, b, i, j);
        return q1 + q2;
    }
}
