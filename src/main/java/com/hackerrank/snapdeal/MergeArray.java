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

package com.hackerrank.snapdeal;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeArray
{
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        int _a_cnt = 0;
        int[] _a = new int[100001];
        int[] _b = new int[200002];

        try {
            _a_cnt = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Here: " + e.getMessage());
        }

        for (int i = 0; i < _a_cnt; i++) {
            _a[i] = sc.nextInt();
        }
        for (int i = 0; i < _a_cnt; i++) {
            _b[i] = sc.nextInt();
        }
        mergeArray(_a, _b, _a_cnt);
        for (int i = 0; i < 2 * _a_cnt; i++) {
            System.out.print(_b[i] + " ");
        }
    }

    static void mergeArray(int[] a, int[] b, int M)
    {
        int[] temp = new int[M];
        System.arraycopy(b, 0, temp, 0, M);

        int index = 0;
        PriorityQueue<Item> pq = new PriorityQueue<>();
        pq.add(new Item(a[0], 0, true));
        pq.add(new Item(temp[0], 0, false));

        while (!pq.isEmpty()) {
            Item n = pq.poll();
            b[index++] = n.value;
            if (n.index + 1 < M) {
                if (n.isFirst) {
                    pq.add(new Item(a[n.index + 1], n.index + 1, true));
                } else {
                    pq.add(new Item(temp[n.index + 1], n.index + 1, false));
                }
            }
        }
    }

    private static class Item implements Comparable<Item>
    {

        private int value;
        private int index;
        private boolean isFirst;

        public Item(int value, int index, boolean isFirst)
        {
            this.value = value;
            this.index = index;
            this.isFirst = isFirst;
        }

        @Override
        public int compareTo(Item that)
        {
            if (this.value > that.value)
                return 1;
            else if (this.value < that.value)
                return -1;
            else
                return 1;

        }
    }

}

