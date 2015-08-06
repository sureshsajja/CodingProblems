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

package com.hackerearth.practicechallenge;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * User : Suresh
 * Date : 29/03/15
 */

/**
 * You are asked to calculate factorials of some small positive integers.
 * <p/>
 * Input
 * An integer T, denoting the number of testcases, followed by T lines, each containing a single integer N.
 * <p/>
 * Output
 * For each integer N given at input, output a single line the value of N!
 * <p/>
 * Input Constraint
 * <p/>
 * 1 <= T <= 100
 * 1 <= N <= 100
 * <p/>
 * <p/>
 * Sample Input (Plaintext Link)
 * 4
 * 1
 * 2
 * 5
 * 3
 * Sample Output (Plaintext Link)
 * 1
 * 2
 * 120
 * 6
 */
public class Factorials {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            BigInteger result = BigInteger.ONE;
            for (int i = 2; i <= N; i++) {
                result = result.multiply(BigInteger.valueOf(i));
            }
            pw.println(result.toString());
        }


        scanner.close();
        pw.close();
    }
}
