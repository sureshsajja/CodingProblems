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

package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndMiniMax
{

    private static int N;
    private static int[] array;
    private static int P;
    private static int Q;
    private static int answer;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        N = scanner.nextInt();
        array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        P = scanner.nextInt();
        Q = scanner.nextInt();

        answer = P;
        limits(P);
        limits(Q);

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                limits((array[i] + array[j]) / 2);
            }
        }

        pw.println(answer);

        scanner.close();
        pw.close();
    }


    private static int check(int x)
    {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i)
            ret = ret > Math.abs(x - array[i]) ? Math.abs(x - array[i]) : ret;
        return ret;
    }

    private static void limits(int x)
    {
        if (x < P || x > Q) return;
        if (check(x) > check(answer)) answer = x;
    }


}
