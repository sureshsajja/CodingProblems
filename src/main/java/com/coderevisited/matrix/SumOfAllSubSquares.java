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
 * In the first iteration find sum of sub matrix of size K x 1
 * In the second iteration find sum of sub square matrix K x K
 */
public class SumOfAllSubSquares
{
    public static void main(String[] args)
    {
        int N = 3, K = 2;
        int[][] matrix = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
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

        int[][] stripSum = new int[k][n];

        /**
         * for array {1,2, 3}
         *           {4, 5, 6}
         *           {7, 8, 9}
         *
         * In first iteration find {5, 7, 9}
         *                      {11, 13, 15}
         *
         * In second iteration find {12, 16}
         *                          (24, 28}
         */

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n - k + 1) {
                for (int p = i; p < i + k; p++) {
                    stripSum[i][j] += matrix[p][j];
                }
                i++;
            }
        }

        int[][] sum = new int[k][k];
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < n - k + 1) {

                for (int p = j; p < j + k; p++) {
                    sum[i][j] += stripSum[i][p];
                }
                j++;
            }
        }

        return sum;


    }
}
