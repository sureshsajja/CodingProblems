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

import com.coderevisited.searching.DuplicateCount;

import java.util.Arrays;

/**
 * 1. Copy A to temp, sort temp
 * 2. create a visit array
 * 3. for each element in B, if it exists in A, copy all occurrences
 * 4. Mark those elements as visited
 * 5. At the end, copy remaining unvisited elements to A.
 */
public class CustomOrderSort
{
    public static void main(String[] args)
    {
        int[] A = new int[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] B = new int[]{2, 1, 8, 3};

        customSort(A, B);

        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void customSort(int[] A, int[] B)
    {
        int[] copy = new int[A.length];
        System.arraycopy(A, 0, copy, 0, A.length);
        boolean[] visited = new boolean[A.length];
        Arrays.sort(copy);
        int index = 0;
        for (int i : B) {
            int min = DuplicateCount.leastIndexBinarySearch(copy, 0, A.length - 1, i);
            if (min != -1) {
                int max = DuplicateCount.maxIndexBinarySearch(copy, 0, A.length - 1, i);
                if (max != -1) {
                    for (int p = min; p <= max; p++) {
                        A[index++] = copy[p];
                        visited[p] = true;
                    }
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            if (!visited[i]) {
                A[index++] = copy[i];
            }
        }
    }
}
