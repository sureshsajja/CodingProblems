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

package com.hackerearth.augustclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MagicBruteForce
{

    private static int[] tenth = new int[10];

    static {
        tenth[0] = 0;
        tenth[1] = 0;
        tenth[2] = 1;
        tenth[3] = 2;
        tenth[4] = 2;
        tenth[5] = 3;
        tenth[6] = 3;
        tenth[7] = 4;
        tenth[8] = 4;
        tenth[9] = 4;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long N = scanner.nextLong();
            if (N < 10)
                pw.println(tenth[((int) N)]);
            else
                pw.println(findMagicNumbers(N));
        }


        scanner.close();
        pw.close();
    }

    private static long findMagicNumbers(long n)
    {
        long result = 0;
        for (long i = 1; i <= n; i++) {
            if (isMagic(i))
                result++;
        }
        return result;
    }


    private static boolean isPrime(int lastDigit)
    {
        return lastDigit == 2 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7;
    }

    private static boolean isMagic(long N)
    {
        while (N != 0) {
            int digit = (int) (N % 10);
            if (isPrime(digit))
                return true;
            N = N / 10;
        }
        return false;
    }
}
