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

package com.coderevisited.sorting;

import java.util.PriorityQueue;

public class MergeKSortedArrays
{
    public static void main(String[] args)
    {
        int N = 3, M = 4;
        int[][] array = new int[][]{{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};

        int[] result = merge(array, N, M);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    private static int[] merge(int[][] array, int N, int M)
    {
        int[] result = new int[M * N];
        int index = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(new Node(array[i][0], i, 0));
        }

        while (!pq.isEmpty()) {
            Node n = pq.poll();
            result[index++] = n.value;
            if (n.column + 1 < M) {
                pq.add(new Node(array[n.row][n.column + 1], n.row, n.column + 1));
            }
        }

        return result;
    }

    private static class Node implements Comparable<Node>
    {
        int value;
        int row;
        int column;

        public Node(int value, int row, int column)
        {
            this.value = value;
            this.row = row;
            this.column = column;
        }


        @Override
        public int compareTo(Node that)
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
