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

package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO optimise this
public class SherlockAndQueries
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        int[] C = new int[M];

        for (int n = 0; n < N; n++) {
            A[n] = scanner.nextInt();
        }

        for (int m = 0; m < M; m++) {
            B[m] = scanner.nextInt();
        }

        for (int m = 0; m < M; m++) {
            C[m] = scanner.nextInt();
        }


        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if ((j % B[i]) == 0) {
                    A[j - 1] = (int) ((A[j - 1] * (long) C[i]) % 1000000007);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            pw.print(A[i]);
            pw.print(" ");
        }


        scanner.close();
        pw.close();
    }
}
