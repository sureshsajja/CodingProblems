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

package com.hackerearth.lenskart;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO optimise
public class AndiAndBob
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                int i = scanner.nextInt();
                if (i % 2 == 0) {
                    array[n] = 0;
                } else {
                    array[n] = 1;
                }
            }

            int[] evenOdd = new int[2];


            subArrayXor(array, 0, N - 1, evenOdd);

            if (evenOdd[0] > evenOdd[1]) {
                pw.println("ANDI");
            } else {
                pw.println("BOB");
            }
        }

        scanner.close();
        pw.close();
    }

    private static void subArrayXor(int[] array, int l, int h, int[] evenOdd)
    {
        if (l == h) {
            evenOdd[array[l]]++;
            return;
        }

        int m = (l + h) / 2;

        subArrayXor(array, l, m, evenOdd);
        subArrayXor(array, m + 1, h, evenOdd);
        subCrossingXor(array, l, m, h, evenOdd);
    }

    private static void subCrossingXor(int arr[], int l, int m, int h, int[] evenOdd)
    {

        for (int k = m; k >= l; k--) {
            int intermediate = arr[k];
            for (int i = m + 1; i <= h; i++) {
                intermediate ^= arr[m];
                evenOdd[intermediate]++;
            }
        }
    }

}
