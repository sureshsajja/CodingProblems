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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MatrixDiagonal
{
    public static void main(String[] args)
    {
        int N = 5;
        int M = 6;
        int[][] matrix = new int[][]{{1, 2, 3, 4, 21, 26},
                {5, 6, 7, 8, 22, 27},
                {9, 10, 11, 12, 23, 28},
                {13, 14, 15, 16, 24, 29},
                {17, 18, 19, 20, 25, 30}};

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = i; j <= i && j < M; j++, k--) {
                pw.print(matrix[k][j] + " ");
            }
            pw.println();
        }

        for (int j = 1; j < M; j++) {
            for (int i = N - 1, k = j; i >= 0 && k < M; i--, k++) {
                pw.print(matrix[i][k] + " ");
            }
            pw.println();
        }
        pw.println();

        pw.close();
    }
}
