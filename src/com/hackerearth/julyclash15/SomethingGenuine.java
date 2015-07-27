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
    private static int[] tree;
    private static int[] lazy;

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
        tree = new int[size];
        lazy = new int[size];



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

    public static void updateTree(int index, int start, int end, int left, int right, int value) {
        if (left > end || right < start) {
            return;
        }
        if (start == end) {
            tree[index] += value;
            if (lazy[index] != 0) {
                tree[index] += lazy[index];
                lazy[index] = 0;
            }
            return;
        }
        if (left <= start && right >= end) {
            lazy[2 * index + 1] += value;
            lazy[2 * index + 2] += value;
            tree[index] += (value * (end - start + 1));
            return;
        } else if (left <= end && right > end)
            tree[index] += (value * (end - left + 1));
        else if (start <= right && left < start)
            tree[index] += (value * (right - start + 1));
        else if (left >= start && right <= end)
            tree[index] += (value * (right - left + 1));

        updateTree(2 * index + 1, start, (start + end) / 2, left, right, value);
        updateTree((2 * index) + 2, ((start + end) / 2) + 1, end, left, right, value);
    }

    public static int queryTree(int index, int start, int end, int left, int right) {
        if (left > end || right < start)
            return 0;
        if (lazy[index] != 0) {
            tree[index] += (lazy[index] * (end - start + 1));
            lazy[index] = 0;
            if (start != end) {
                lazy[2 * index + 1] += lazy[index];
                lazy[2 * index + 2] += lazy[index];
            }
            lazy[index] = 0;
        }
        if (left <= start && right >= end) {
            return tree[index];
        }
        int s1 = queryTree(2 * index + 1, start, (start + end) / 2, left, right);
        int s2 = queryTree(2 * index + 2, ((start + end) / 2) + 1, end, left, right);
        return s1 + s2;
    }


}
