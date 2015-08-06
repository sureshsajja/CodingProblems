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
 * Algorithm:
 * 1. Progressively construct result matrix S[][]
 * 1. Initially copy first row and first column to result matrix
 * 2. Start from (1,1), at each step if matrix[i][j] = 1, S[i][j] = min{S[i-1][j], S[i][j-1], S[i-1][j-1]} +1
 * 3. Traverse S[i][j] to check the maximum value and it's index
 */
public class MaximumSizeSquareSubMatrix
{

    public static void main(String[] args)
    {
        int N = 6, M = 5;
        int[][] matrix = new int[][]{{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSizeSquareSubMatrix(matrix, N, M);
    }

    private static void printMaxSizeSquareSubMatrix(int[][] matrix, int N, int M)
    {

        int[][] s = new int[N][M];

        System.arraycopy(matrix[0], 0, s[0], 0, M);

        for (int i = 0; i < N; i++) {
            s[i][0] = matrix[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == 1) {
                    //top
                    int min = s[i - 1][j];

                    //left
                    if (s[i][j - 1] < min) {
                        min = s[i][j - 1];
                    }

                    //top left corner

                    if (s[i - 1][j - 1] < min) {
                        min = s[i - 1][j - 1];
                    }

                    s[i][j] = min + 1;

                } else {
                    s[i][j] = 0;
                }
            }
        }

        int max = s[0][0], p = 0, q = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < s[i][j]) {
                    max = s[i][j];
                    p = i;
                    q = j;
                }
            }
        }

        for (int i = p - max + 1; i <= p; i++) {
            for (int j = q - max + 1; j <= q; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
