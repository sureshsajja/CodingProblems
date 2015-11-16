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

package com.hackerrank.week8;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 1+nc1+n-2c2+n-4c3+n-6c4 ... until n>=k
 */
public class NecklaceBruteForce
{
    private static int MAX = 10000;
    private static int[][] matrix = new int[MAX + 1][MAX + 1];
    private static int MOD = 1000000000 + 7;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            pw.println(count(i));
        }

        pw.close();
        scanner.close();
    }

    private static int count(int i)
    {
        int result = 1;
        for (int n = i, k = 1; n >= k; n -= 2, k++) {
            int r = k;
            if (k > n / 2) {
                r = n - k;
            }
            if (matrix[n][r] == 0) {
                calculateValue(n, r);
            }
            result = (int) ((result + (long) matrix[n][r]) % MOD);
        }
        return result;
    }

    private static int calculateValue(int n, int k)
    {

        if (matrix[n][k] != 0) {
            return matrix[n][k];
        }

        for (int i = 0; i <= n; i++) {
            if (matrix[i][k] == 0) {
                for (int j = 0; j <= k; j++) {
                    if (matrix[i][j] == 0) {
                        if (j == 0 || i == 0 || i == j) {
                            matrix[i][j] = 1;
                        } else {
                            matrix[i][j] = (int) (matrix[i - 1][j - 1] + (long) matrix[i - 1][j]) % MOD;
                        }
                    }
                }
            }
        }
        return matrix[n][k];
    }
}
