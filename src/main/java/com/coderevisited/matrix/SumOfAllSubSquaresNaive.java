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

package com.coderevisited.matrix;

/**
 * Given an n x n square matrix, find sum of all sub-squares of size k x k where k is smaller than or equal to n.
 */
public class SumOfAllSubSquaresNaive
{

    public static void main(String[] args)
    {
        int N = 5;
        int[][] matrix = new int[][]{{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int K = 3;
        int[][] sum = getSumMatrix(matrix, N, K);
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] getSumMatrix(int[][] matrix, int n, int k)
    {
        int[][] sum = new int[k][k];
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {

                for (int p = i; p < k + i; p++) {
                    for (int q = j; q < k + j; q++) {
                        sum[p - i][q - j] += matrix[p][q];
                    }
                }

            }
        }
        return sum;
    }
}
