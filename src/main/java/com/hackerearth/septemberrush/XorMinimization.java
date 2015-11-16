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

package com.hackerearth.septemberrush;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO test
public class XorMinimization
{
    private static final int MOD = 1000000007;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        int max = 0;
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
            max = array[n] > max ? array[n] : max;
        }

        int[] hist = new int[100001];

        findSubsetSum(0, array, 0, new int[100], hist);

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int A = scanner.nextInt();

            int min = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 1; i <= max * N; i++) {
                if (hist[i] != 0) {
                    int xor = i ^ A;
                    if (xor < min) {
                        min = xor;
                        minIndex = i;
                    }
                }
            }
            pw.println(minIndex + " " + hist[minIndex]);
        }

        scanner.close();
        pw.close();
    }

    private static void findSubsetSum(int start, int[] array, int k, int[] result, int[] hist)
    {
        if (k > 0) {
            int count = 0;
            for (int i = 0; i < k; i++) {
                count += result[i];
            }
            hist[count]++;
            if (hist[count] > MOD) {
                hist[count] %= MOD;
            }
        }
        for (int i = start; i < array.length; i++) {
            result[k] = array[i];
            findSubsetSum(i + 1, array, k + 1, result, hist);
        }
    }
}
