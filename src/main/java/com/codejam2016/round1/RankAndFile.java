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

package com.codejam2016.round1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 16/04/16
 * Version : v1
 */
public class RankAndFile {


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

        int T = nextInt();
        for (int t = 1; t <= T; t++) {

            int N = nextInt();
            int[][] array = new int[2 * N][N];

            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            List<String> set = new LinkedList<>();
            for (int i = 0; i < 2 * N - 1; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    array[i][j] = nextInt();
                    sb.append(array[i][j]);
                }
                set.add(sb.toString());
                if (array[i][0] < min) {
                    min = array[i][0];
                    minIndex = i;
                }
            }

            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                matrix[0][j] = array[minIndex][j];
                array[minIndex][j] = -1;
            }


            for (int j = 0; j < N; j++) {
                int s = matrix[0][j];

                for (int i = 0; i < 2 * N; i++) {

                    if (array[i][0] == s) {
                        for (int k = 0, p = 0; k < N; k++, p++) {
                            matrix[p][j] = array[i][k];
                            array[i][k] = -1;
                        }
                        break;
                    }

                }
            }


            for (int i = 1; i < N; i++) {
                int s = matrix[i][0];
                if (s == 0)
                    continue;

                for (int p = 0; p < 2 * N; p++) {
                    if (array[p][0] == s) {
                        for (int k = 0, l = 0; k < N; k++, l++) {
                            matrix[i][l] = array[p][k];
                            array[p][k] = -1;
                        }
                        break;
                    }
                }
            }


            for (int i = 1; i < N; i++) {
                int s = matrix[i][N - 1];
                if (s == 0) {
                    continue;
                }

                for (int p = 0; p < 2 * N; p++) {
                    if (array[p][N - 1] == s) {
                        for (int k = N - 1, l = N - 1; k >= 0; k--, l--) {
                            matrix[i][l] = array[p][k];
                            array[p][k] = -1;
                        }
                        break;
                    }
                }
            }


            for (int j = 0; j < N; j++) {
                int s = matrix[N - 1][j];
                for (int i = 0; i < 2 * N; i++) {
                    if (array[i][N - 1] == s) {
                        for (int k = N - 1, p = N - 1; k >= 0; k--, p--) {
                            matrix[p][j] = array[i][k];
                            array[i][k] = -1;
                        }
                        break;
                    }
                }
            }





            pw.print("Case #" + t + ":");
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(matrix[i][j]);
                }
                if (!set.contains(sb.toString())) {
                    for (int j = 0; j < N; j++) {
                        pw.print(" " + matrix[i][j]);
                    }
                    pw.println();
                    break;
                }else{
                    set.remove(sb.toString());
                }

            }


            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(matrix[j][i]);
                }
                if (!set.contains(sb.toString())) {
                    for (int j = 0; j < N; j++) {
                        pw.print(" " + matrix[j][i]);
                    }
                    pw.println();
                    break;
                }else{
                    set.remove(sb.toString());
                }

            }
        }

        reader.close();
        pw.close();

    }
}
