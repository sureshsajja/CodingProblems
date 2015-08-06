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
 * <p> f(n) = f(n-1)+f(n-3) </p>
 * <p/>
 * http://zobayer.blogspot.sg/2010/11/matrix-exponentiation.html
 * <p/>
 * http://thecodegame.wordpress.com/2012/09/11/solving-linear-recurrence-relation-using-matrix-multiplication/
 */
public class Necklace
{
    private static int MOD = 1000000000 + 7;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long i = scanner.nextLong();
            if (i < 2) {
                pw.println(0);
            } else {
                pw.println(count(i));
            }
        }

        scanner.close();
        pw.close();
    }

    private static long count(long n)
    {
        long[] F = new long[]{3, 2, 1};
        if (n == 2) {
            return F[0];
        }

        long[][] M = new long[][]{{1, 0, 1}, {1, 0, 0}, {0, 1, 0}};
        raiseMtoPower(M, n - 2);
        multiplyMF(M, F);
        return (F[0]);
    }

    private static void multiplyMF(long[][] M, long[] F)
    {

        long x = ((F[0] * M[0][0]) % MOD + ((F[1] * M[0][1]) % MOD) + ((F[2] * M[0][2]) % MOD)) % MOD;
        long y = ((F[0] * M[1][0]) % MOD + ((F[1] * M[1][1]) % MOD) + ((F[2] * M[1][2]) % MOD)) % MOD;
        long z = ((F[0] * M[2][0]) % MOD + ((F[1] * M[2][1]) % MOD) + ((F[2] * M[2][2]) % MOD)) % MOD;
        F[0] = x;
        F[1] = y;
        F[2] = z;

    }

    private static void raiseMtoPower(long[][] m, long k)
    {
        if (k == 0 || k == 1 || k < 0) {
            return;
        }
        long[][] f = new long[][]{{1, 0, 1}, {1, 0, 0}, {0, 1, 0}};

        raiseMtoPower(m, k >> 1);
        multiplyMN(m, m);

        if ((k & 1) == 1) {
            multiplyMN(m, f);
        }
    }

    private static void multiplyMN(long[][] M, long[][] N)
    {
        long[][] L = new long[3][3];
        L[0][0] = ((M[0][0] * N[0][0]) % MOD + (M[0][1] * N[1][0]) % MOD + (M[0][2] * N[2][0]) % MOD) % MOD;
        L[0][1] = ((M[0][0] * N[0][1]) % MOD + (M[0][1] * N[1][1]) % MOD + (M[0][2] * N[2][1]) % MOD) % MOD;
        L[0][2] = ((M[0][0] * N[0][2]) % MOD + (M[0][1] * N[1][2]) % MOD + (M[0][2] * N[2][2]) % MOD) % MOD;
        L[1][0] = ((M[1][0] * N[0][0]) % MOD + (M[1][1] * N[1][0]) % MOD + (M[1][2] * N[2][0]) % MOD) % MOD;
        L[1][1] = ((M[1][0] * N[0][1]) % MOD + (M[1][1] * N[1][1]) % MOD + (M[1][2] * N[2][1]) % MOD) % MOD;
        L[1][2] = ((M[1][0] * N[0][2]) % MOD + (M[1][1] * N[1][2]) % MOD + (M[1][2] * N[2][2]) % MOD) % MOD;
        L[2][0] = ((M[2][0] * N[0][0]) % MOD + (M[2][1] * N[1][0]) % MOD + (M[2][2] * N[2][0]) % MOD) % MOD;
        L[2][1] = ((M[2][0] * N[0][1]) % MOD + (M[2][1] * N[1][1]) % MOD + (M[2][2] * N[2][1]) % MOD) % MOD;
        L[2][2] = ((M[2][0] * N[0][2]) % MOD + (M[2][1] * N[1][2]) % MOD + (M[2][2] * N[2][2]) % MOD) % MOD;
        for (int i = 0; i < 3; i++) {
            System.arraycopy(L[i], 0, M[i], 0, 3);
        }
    }
}

