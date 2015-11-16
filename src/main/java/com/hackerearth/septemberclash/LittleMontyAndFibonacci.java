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

package com.hackerearth.septemberclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class LittleMontyAndFibonacci
{

    private static BigInteger[] fibNumber = new BigInteger[1001];
    private static int[] multipleSum = new int[1001];

    static {
        fibNumber[0] = BigInteger.ONE;
        fibNumber[1] = BigInteger.ONE;

        multipleSum[0] = 1;
        multipleSum[1] = 4;
        multipleSum[2] = 7;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        fib(1000);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            pw.println(multiple(N - 1));
        }

        scanner.close();
        pw.close();
    }

    private static BigInteger fib(int i)
    {

        if (fibNumber[i] != null) {
            return fibNumber[i];
        } else {
            return fibNumber[i] = fib(i - 1).add(fib(i - 2));
        }

    }

    private static int multiple(int n)
    {
        if (multipleSum[n] != 0)
            return multipleSum[n];
        else {

            int present = 0;
            BigInteger bigInt = fibNumber[n];
            for (int m = 0; m <= n; m++) {
                if (bigInt.remainder(fibNumber[m]).equals(BigInteger.ZERO)) {
                    present++;
                }
            }

            return multipleSum[n] = present + multiple(n - 1);
        }
    }
}
