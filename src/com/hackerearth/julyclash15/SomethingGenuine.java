/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Suresh Sajja
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

package com.hackerearth.julyclash15;


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  18/07/15
 * Version : v1
 */
public class SomethingGenuine {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static int[] sum;
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


        int N = nextInt();

        int log = (int) Math.ceil(Math.log(N) / Math.log(2));
        int size = 2 * (int) Math.pow(2, log) - 1;
        sum = new int[size];
        lazy = new int[size];
        tree = new int[size];



        int[] last = new int[N];
        for (int i = 0; i < N; i++) {
            last[i] = -1;
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int a = nextInt();
            updateTree(0, 0, N - 1, last[a] + 1, i, 1);
            int current = queryTree(0, 0, N - 1, 0, i);
            ans += current;
            last[a] = i;
        }

        pw.println(ans);


        reader.close();
        pw.close();
    }

    public static void updateTree(int index, int a, int b, int i, int j, int value) {

        if (lazy[index] != 0) {
            tree[index] += (2 * lazy[index] * sum[index]) + ((b - a + 1) * (lazy[index] * lazy[index]));
            sum[index] += lazy[index] * (b - a + 1);
            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }
            lazy[index] = 0;
        }

        if (a > b || a > j || b < i)
            return;

        if (a >= i && b <= j) {
            tree[index] += (2 * value * sum[index]) + (b - a + 1) * (value * value);
            sum[index] += value * (b - a + 1);
            if (a != b) {
                lazy[index * 2 + 1] += value;
                lazy[index * 2 + 2] += value;
            }
            return;
        }

        updateTree(index * 2 + 1, a, (a + b) / 2, i, j, value);
        updateTree(index * 2 + 2, (a + b) / 2 + 1, b, i, j, value);
        sum[index] = sum[2 * index + 1] + sum[2 * index + 2];
        tree[index] = tree[2 * index + 1] + tree[2 * index + 2];

    }

    public static int queryTree(int index, int a, int b, int i, int j) {

        if (a > b || a > j || b < i)
            return 0;

        if (lazy[index] != 0) {
            tree[index] += (2 * lazy[index] * sum[index]) + ((b - a + 1) * (lazy[index] * lazy[index]));
            sum[index] += lazy[index] + (b - a + 1);

            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (a >= i && b <= j)
            return tree[index];

        int q1 = queryTree(index * 2 + 1, a, (a + b) / 2, i, j);
        int q2 = queryTree(index * 2 + 2, 1 + (a + b) / 2, b, i, j);
        return q1 + q2;
    }


}
