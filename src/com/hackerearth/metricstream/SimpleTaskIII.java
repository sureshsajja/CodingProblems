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

package com.hackerearth.metricstream;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * User : Suresh
 * Date : 28/03/15
 */

/**
 * Name string is a string consisting of letters "R","K" and "V". Today Oz wants to design a name string in a beautiful manner. Actually Oz cannot insert these three letters arbitrary anywhere ,he has to follow some rules to make the name string look beautiful. First thing is that the name string should consist of at most two different letters. Secondly adjacent letters in name string must be different.
 * <p/>
 * After this procedure Oz wants name string to be as long as possible. Given the number of "R","K" and "V" letters that you have initially ,help Oz to find the maximum length of name string that Oz can make.
 * <p/>
 * Input :
 * The first line contains the number of test cases T . Each test case consists of three space separated integers - A,B and C representing number of "R" letters, number of "K" letters and number of "V" letters respectively.
 * <p/>
 * Output :
 * For each test case T, output maximum length of name string that Oz can make.
 * <p/>
 * Constraints :
 * 1 <= T <=100
 * 0 <= A,B,C <=106
 * <p/>
 * Input
 * =====
 * 2
 * 1 2 5
 * 0 0 2
 * <p/>
 * Output
 * ======
 * 5
 * 1
 * <p/>
 * <p/>
 * Solution
 * =======
 * Since we are looking for maximum string to be formed using two letters, sort number of letters in decreasing order
 * Say A[0],A[1], A[3] are in non increasing order.
 * if(A[0] == A[1]) maximum String length will be 2* A[0]
 * else maximum String length will be 2*A[1]+1;
 */
public class SimpleTaskIII {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int[] rkv = new int[3];

            rkv[0] = scanner.nextInt();
            rkv[1] = scanner.nextInt();
            rkv[2] = scanner.nextInt();

            Arrays.sort(rkv);
            if (rkv[2] > rkv[1]) {
                pw.println(rkv[1] + rkv[1] + 1);
            } else
                pw.println(rkv[1] + rkv[1]);

        }


        scanner.close();
        pw.close();
    }
}
