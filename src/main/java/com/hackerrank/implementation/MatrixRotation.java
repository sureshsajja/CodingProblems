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
 */

package com.hackerrank.implementation;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 17/03/16
 * Version : v1
 */

/**
 * https://www.hackerrank.com/challenges/matrix-rotation-algo
 */
public class MatrixRotation {


    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }


    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int M = nextInt();
        int N = nextInt();
        int R = nextInt();
        int[][] matrix = new int[M][N];
        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                matrix[m][n] = nextInt();
            }
        }


        int min = Math.min(M, N);

        for (int i = 0; i < min / 2; i++) {
            int rotations = R % ((M + N - 2 - 4 * i) * 2);
            for (int r = 0; r < rotations; r++) {

                int temp = matrix[i][i];
                int m = i;
                for (int n = i + 1; n < N - i; n++) {
                    matrix[m][n - 1] = matrix[m][n];
                }

                int n = N - i - 1;
                for (m = i + 1; m < M - i; m++) {
                    matrix[m - 1][n] = matrix[m][n];
                }

                m = M - i - 1;
                for (n = N - i - 1; n >= i + 1; n--) {
                    matrix[m][n] = matrix[m][n - 1];
                }

                n = i;
                for (m = M - i - 1; m > i + 1; m--) {
                    matrix[m][n] = matrix[m - 1][n];
                }

                matrix[m][n] = temp;
            }

        }


        for (int m = 0; m < M; m++) {
            for (int n = 0; n < N; n++) {
                pw.print(matrix[m][n] + " ");
            }
            pw.println();
        }


        reader.close();
        pw.close();

    }

}
