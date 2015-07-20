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
    private static final int MOD = 1000000007;
    private static Segment[] tree;

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
        tree = new Segment[size];
        init(0, 0, N - 1);
        int[] A = new int[N];

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int a = nextInt();
            update(0, 0, N-1, A[a], i);
            ans = (ans + query(1, 1, N, 1, i)) % MOD;
            A[a] = i;
        }

        pw.println(ans);


        reader.close();
        pw.close();
    }

    private static void update(int index, int start, int end, int left, int right) {
        if (right < start || end < left)
            return;
        if (left <= start && end <= right)
            modify(index, 1);
        else {
            down(index);
            int mid = (start + end) / 2;
            update(index * 2 + 1, start, mid, left, right);
            update(index * 2 + 2, mid + 1, end, left, right);
            tree[index].sum1 = (tree[index * 2 + 1].sum1 + tree[index * 2 + 2].sum1) % MOD;
            tree[index].sum2 = (tree[index * 2 + 1].sum2 + tree[index * 2 + 2].sum2) % MOD;
        }
    }

    private static void modify(int index, int v) {
        tree[index].sum2 = (int) ((tree[index].sum2 + 2L * tree[index].sum1 * v + (long) tree[index].sum0 * v * v) % MOD);
        tree[index].sum1 = (int) ((tree[index].sum1 + (long) tree[index].sum0 * v) % MOD);
        tree[index].lazy += v;
    }

    private static void init(int index, int start, int end) {
        if (start == end) {
            tree[index] = new Segment();
            tree[index].sum0 = 1;
            tree[index].sum1 = 0;
            tree[index].sum2 = 0;
        } else {
            int mid = (start + end) / 2;
            init(index * 2 + 1, start, mid);
            init(index * 2 + 2, mid + 1, end);
            tree[index] = new Segment();
            tree[index].sum0 = tree[index * 2 + 1].sum0 + tree[index * 2 + 2].sum0;
        }
    }

    private static int query(int index, int start, int end, int left, int right) {
        if (right < start || end < start)
            return 0;
        if (left <= start && end <= right)
            return tree[index].sum2;
        down(index);
        int mid = (start + end) / 2;
        return (query(index * 2, start, mid, left, right) +
                query(index * 2 + 1, mid + 1, end, left, right)) % MOD;
    }

    private static void down(int index) {
        if (tree[index].lazy != 0) {
            modify(index * 2, tree[index].lazy);
            modify(index * 2 + 1, tree[index].lazy);
            tree[index].lazy = 0;
        }
    }

    private static class Segment {
        int sum0;
        int sum1;
        int sum2;
        int lazy;
    }
}
