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
import java.util.Scanner;

/**
 * User : Suresh
 * Date : 28/03/15
 */

/**
 * Xsquare loves to play with the coins very much. Today , he has N stacks of coins . Each stack of coins has some non zero height Hi equal to the number of coins on that stack ( considering all the coins are identical and each coin has a height of 1 unit ) .
 * <p/>
 * In one move, Xsquare can select any number of consecutive stacks of coins such that the height of each selected stack of coins Hi ≤ K . Once such a sequence of stacks is chosen , Xsquare can collect any number of coins from the chosen sequence of stacks .
 * <p/>
 * Xsquare wonders what is the maximum number of coins that he can collect this way ?
 * <p/>
 * INPUT
 * <p/>
 * First line of input contains a single integer T denoting the number of test cases . First line of each test case contains two space separated integers N and K where N being the number of stacks of coins. Second line of each test case contains N space separated integers denoting the number of coins Hi on each stack .
 * <p/>
 * OUTPUT
 * <p/>
 * For each test case , Print the maximum number of coins Xsquare can collect following the above gaming strategy.
 * <p/>
 * CONSTRAINTS
 * <p/>
 * 1 ≤ T ≤ 105
 * <p/>
 * 1 ≤ N ≤ 105
 * <p/>
 * 1 ≤ K ≤ 109
 * <p/>
 * 1 ≤ Hi ≤ 109
 * <p/>
 * Note :
 * <p/>
 * sum of N over all the test case will not exceed 106.
 * <p/>
 * <p/>
 * Input
 * =====
 * 2
 * 8 1
 * 3 2 2 3 1 1 1 3
 * 8 2
 * 3 2 2 3 1 1 1 3
 * <p/>
 * <p/>
 * Output
 * ======
 * 3
 * 4
 * <p/>
 * <p/>
 * Solution
 * =======
 * Problem is required to be solved for just one move. Coins are required to be collected from stacks whose H <= K.
 * max of { sum of coins in consecutive stacks whose H <=k }
 */
public class XsquareAndCoinCollection {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            long maxCollected = 0;
            long collected = 0;
            for (int n = 0; n < N; n++) {
                int i = scanner.nextInt();
                if (i <= K) {
                    collected += i;
                } else {
                    if (collected > maxCollected) {
                        maxCollected = collected;
                    }
                    collected = 0;
                }

            }
            if (collected > maxCollected) {
                maxCollected = collected;
            }
            pw.println(maxCollected);
        }


        scanner.close();
        pw.close();
    }


}
