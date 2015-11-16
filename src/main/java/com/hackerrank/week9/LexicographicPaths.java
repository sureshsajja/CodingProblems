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

package com.hackerrank.week9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LexicographicPaths
{

    private static int[] next_perm = new int[2097152];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int V = 0;
            for (int n = 0; n < N; n++) {
                V += Math.pow(2, n);
            }

            int ans = findKthPerm(V, K);

            String s = String.format("%" + (M + N) + "s", Integer.toBinaryString(ans)).replace(' ', '0');
            s = s.replace('0', 'H');
            s = s.replace('1', 'V');
            pw.println(s);
        }
        pw.close();
        scanner.close();
    }

    private static int findKthPerm(int V, int K)
    {
        while (K > 0) {
            V = next_perm(V);
            K--;
        }
        return V;
    }

    private static int next_perm(int v)
    {
        if (next_perm[v] == 0) {
            int t = (v | (v - 1)) + 1;
            next_perm[v] = t | ((((t & -t) / (v & -v)) >> 1) - 1);
        }
        return next_perm[v];
    }


}
