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

/**
 * http://stackoverflow.com/a/11156949
 */
public class AaryanAndTheMagicalNumbers
{
    private static long[] table = new long[19];
    private static int[] tenth = new int[10];

    static {
        table[0] = 0L;
        table[1] = 6L;
        table[2] = table[1] * 6L;
        table[3] = table[2] * 6L;
        table[4] = table[3] * 6L;
        table[5] = table[4] * 6L;
        table[6] = table[5] * 6L;
        table[7] = table[6] * 6L;
        table[8] = table[7] * 6L;
        table[9] = table[8] * 6L;
        table[10] = table[9] * 6L;
        table[11] = table[10] * 6L;
        table[12] = table[11] * 6L;
        table[13] = table[12] * 6L;
        table[14] = table[13] * 6L;
        table[15] = table[14] * 6L;
        table[16] = table[15] * 6L;
        table[17] = table[16] * 6L;
        table[18] = table[17] * 6L;

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
                pw.println(N - findNotMagicNumbers(N));
        }

        scanner.close();
        pw.close();
    }

    private static long findNotMagicNumbers(long N)
    {
        int i = findMaxTenth(N);
        long maxPower = (long) Math.pow(10, i);
        long notMagic = 0;
        long value = 0;
        while (value < N && maxPower >= 10) {
            for (int k = 0; value + maxPower <= N; k++) {
                if (notMagic(value) && !isPrime(k)) {
                    notMagic += table[i];
                }
                value += maxPower;
            }
            i--;
            maxPower /= 10;
        }

        if (!notMagic(value))
            notMagic--;

        value++;
        while (value <= N) {
            if (notMagic(value))
                notMagic++;
            value++;
        }
        return notMagic;

    }

    private static boolean notMagic(long N)
    {
        while (N != 0) {
            int digit = (int) (N % 10);
            if (isPrime(digit))
                return false;
            N = N / 10;
        }
        return true;
    }

    private static int findMaxTenth(long N)
    {
        int i = 0;
        while (N >= 10) {
            N = N / 10;
            i++;
        }
        return i;

    }

    private static boolean isPrime(int lastDigit)
    {
        return lastDigit == 2 || lastDigit == 3 || lastDigit == 5 || lastDigit == 7;
    }
}
