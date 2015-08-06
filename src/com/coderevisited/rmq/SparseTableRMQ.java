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

package com.coderevisited.rmq;

import com.coderevisited.math.utils.MathUtils;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
 */
public class SparseTableRMQ
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        int[][] matrix = new int[N][(int) (MathUtils.log(N, 2) + 1)];

        for (int i = 0; i < N; i++) {
            matrix[i][0] = i;
        }

        for (int j = 1; 1 << j <= N; j++) {
            for (int i = 0; i + (1 << j) - 1 < N; i++) {
                if (array[matrix[i][j - 1]] < array[matrix[i + (1 << (j - 1))][j - 1]]) {
                    matrix[i][j] = matrix[i][j - 1];
                } else {
                    matrix[i][j] = matrix[i + (1 << (j - 1))][j - 1];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                pw.print(matrix[i][j] + " ");
            }
            pw.println();
        }

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int K = (int) MathUtils.log(B - A + 1, 2);
            if (array[matrix[A][K]] < array[matrix[B - (1 << K) + 1][K]]) {
                pw.println(matrix[A][K]);
            } else
                pw.println(matrix[B - (1 << K) + 1][K]);

        }

        scanner.close();
        pw.close();
    }
}
