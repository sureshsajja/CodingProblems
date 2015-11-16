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

package com.hackerearth.druva;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 06/06/15.
 */
public class LittleDeepuAndArraySegmentTree {


    private static int[] array;
    private static int[] tree;
    private static int[] lazy;

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
        array = new int[N];
        List<ArrayNumber> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(new ArrayNumber(i, nextInt()));
        }

        Collections.sort(list, new Comparator<ArrayNumber>() {
            @Override
            public int compare(ArrayNumber o1, ArrayNumber o2) {
                if (o1.value > o2.value) {
                    return 1;
                } else if (o1.value == o2.value) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        int i = 0;
        for (ArrayNumber _array : list) {
            array[i++] = _array.value;
        }

        int log = (int) Math.ceil(Math.log(array.length) / Math.log(2));
        int size = 2 * (int) Math.pow(2, log) - 1;

        tree = new int[size];
        lazy = new int[size];

        buildTree(0, 0, N - 1);

        int M = nextInt();
        for (int m = 0; m < M; m++) {
            int x = nextInt();
            updateTree(0, 0, N - 1, 0, N - 1, x, -1);
        }

        for (i = 0; i < N; i++) {
            list.get(i).value = queryTree(0, 0, N - 1, i, i);
        }

        Collections.sort(list, new Comparator<ArrayNumber>() {
            @Override
            public int compare(ArrayNumber o1, ArrayNumber o2) {
                if (o1.index > o2.index) {
                    return 1;
                } else if (o1.index == o2.index) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (int j = 0; j < N; j++) {
            pw.print(list.get(j).value + " ");
        }
        pw.println();

        reader.close();
        pw.close();
    }


    public static void buildTree(int index, int a, int b) {

        if (a > b) {
            return;
        }
        if (a == b) {
            tree[index] = array[a];
            return;
        }
        buildTree(2 * index + 1, a, (a + b) / 2);
        buildTree(2 * index + 2, (a + b) / 2 + 1, b);
        if (tree[2 * index + 1] < tree[2 * index + 2]) {
            tree[index] = tree[2 * index + 1];
        } else
            tree[index] = tree[2 * index + 2];
    }


    /**
     * Increament elements with range i, j
     */
    public static void updateTree(int index, int a, int b, int i, int j, int x, int value) {

        if (a > b || a > j || b < i)
            return;

        if (lazy[index] != 0) {
            tree[index] += lazy[index];
            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }
            lazy[index] = 0;
        }


        if (a >= i && b <= j && tree[index] > x) {
            tree[index] += value;
            if (a != b) {
                lazy[index * 2 + 1] += value;
                lazy[index * 2 + 2] += value;
            }
            return;
        }
        if (a == b) return;
        updateTree(index * 2 + 1, a, (a + b) / 2, i, j, x, value);
        updateTree(index * 2 + 2, (a + b) / 2 + 1, b, i, j, x, value);
        if (tree[2 * index + 1] < tree[2 * index + 2]) {
            tree[index] = tree[2 * index + 1];
        } else
            tree[index] = tree[2 * index + 2];

    }

    public static int queryTree(int index, int a, int b, int i, int j) {

        if (a > b || a > j || b < i)
            return Integer.MAX_VALUE;

        if (lazy[index] != 0) {
            tree[index] += lazy[index];

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

        return q1 < q2 ? q1 : q2;
    }

    private static class ArrayNumber {

        int index;
        int value;

        public ArrayNumber(int index, int value) {
            this.index = index;
            this.value = value;
        }

    }
}
