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

package com.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Andrew is very fond of Maths.He has N boxes with him,in each box there is some value which represents the Strength of
 * the Box.The ith box has strength A[i]. He wants to calculate the Overall Power of the all N Boxes. Overall Power here
 * means Sum of Absolute Difference of the strengths of the boxes(between each pair of boxes) multiplied by the Maximum
 * strength among N boxes. Since the Overall Power could be a very large number,output the number modulus
 * 10^9+7(1000000007).
 * <p/>
 * Input
 * =====
 * First line of the input contains the number of test cases T. It is followed by T test cases. Each test
 * case has 2 lines. First line contains the number of boxes N. It is followed by a line containing N elements where ith
 * element is the strength of Andrew's ith box.
 * <p/>
 * Output
 * ======
 * For each test case, output a single number, which is the Overall Power for that test case.
 * <p/>
 * Constraints
 * ===========
 * 1<=T<= 10
 * 2<=N<=10^5
 * 0<=A[i]<=10^9
 * <p/>
 * Sample Input
 * ============
 * 2
 * 2
 * 1 2
 * 5
 * 4 5 3 1 2
 * <p/>
 * Output ====== 2 100
 */
public class GameOfStrengths
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Long[] array = new Long[N];
            for (int n = 0; n < N; n++) {
                array[n] = (long) scanner.nextInt();
            }

            long MOD = 1000000007L;
            Arrays.sort(array, Collections.reverseOrder());
            long sum = 0L;
            for (int i = 0; i < N - 1; i++) {
                sum = (100000L * 1000000007 + sum + (N - 1 - i) * array[i] - (N - 1 - i) * array[N - 1 - i]) % MOD;
            }
            sum = (sum * array[0]) % MOD;
            System.out.println(sum);
        }
    }
}
