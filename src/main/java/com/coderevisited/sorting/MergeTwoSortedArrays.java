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

package com.coderevisited.sorting;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 12/07/16
 * Version : v1
 */
public class MergeTwoSortedArrays {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;


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
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {

        int N = nextInt();
        int M = nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        for (int n = 0; n < N; n++) {
            A[n] = nextInt();
        }

        for (int m = 0; m < M; m++) {
            B[m] = nextInt();
        }

        merge(A, B);

        for (int i : A) {
            pw.print(i + " ");
        }
        pw.println();
        for (int i : B) {
            pw.print(i + " ");
        }
        pw.println();


    }

    private static void merge(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        while (i < A.length) {
            //Compare A[0] with B[0], Exchange if required.
            if (A[i] > B[j]) {
                int temp = A[i];
                A[i] = B[j];
                B[j] = temp;
                int k = j + 1;

                //Maintain the sorting order in second array
                while(k < B.length && B[k-1] > B[k]){
                    temp = B[k];
                    B[k] = B[k-1];
                    B[k-1] = temp;
                    k++;
                }
            }
            i++;
        }

    }
}
