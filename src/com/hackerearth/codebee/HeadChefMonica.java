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

package com.hackerearth.codebee;

import java.io.*;
import java.util.StringTokenizer;

/**
 * User : Suresh
 * Date : 25/04/15
 */

/**
 * Monica is the Head-chef at Javu's restaurant. Javu has N kitchen workers, numbered from 1 to N. Each kitchen worker has expertise in exactly one of the following fields:
 * <p/>
 * VEG - denoted as V
 * NONVEG - denoted as N
 * GRILL - denoted as G
 * TOAST - denoted as T
 * SANDWICH - denoted as S
 * BURGER - denoted as B
 * PIZZA - denoted as P
 * You'll be given the string S1 of length N, where ith character defines the field of expertise of ith worker, 1 ≤ i ≤ N.
 * Now, a customer's order contains 3 fields:
 * <p/>
 * 1st field	2nd field	3rd field
 * VEG or NONVEG (V or N)	GRILL or TOAST (G or T)	SANDWICH or BURGER or PIZZA (S or B or P)
 * You'll be given a string S2 of length 3, where jth character defines the jth field of the order, 1 ≤ j ≤ 3.
 * The first character will either be V or N. Second character will either be G or T. Third character will either be S or B or P.
 * <p/>
 * According to the customer order, Monica has to form a team of workers who can prepare the order. Javu has received M orders at the moment. You have to find in how many ways can Monica prepare a team of 3 workers for each of the orders.
 * <p/>
 * Note: One worker can only work in one team. See the sample test case for clarification.
 * <p/>
 * Input:
 * First line of input contains N - number of workers.
 * Second line contains a string S1 of length N, where ith character defines the field of expertise of ith worker, 1 ≤ i ≤ N.
 * Third lines contains M - number of orders.
 * Each of the next M lines contain an order query S2.
 * <p/>
 * Output:
 * For each order query, print the number of ways Monica can form a team of 3 workers who can prepare the order.
 * Since the answer can be very large, print it modulo 1000000007 ( 109 + 7 )
 * <p/>
 * Constraints:
 * 1 ≤ N ≤ 1000000
 * String S1 will be of length N and will only contain upper case character [V, N, G, T, S, B, P]
 * 1 ≤ M ≤ 300000
 * String S2 will be of length 3 and will only contain upper case character [V, N, G, T, S, B, P]
 * <p/>
 * Sample Input
 * ============
 * 11
 * VBVNSSTSBGG
 * 5
 * VGS
 * NTS
 * NGS
 * VGS
 * VGB
 * Sample Output
 * =============
 * 12
 * 2
 * 0
 * 1
 * 0
 * Explanation
 * <p>Initially we have following number of employees of each field:
 * {'B': 2, 'G': 2, 'N': 1, 'P': 0, 'S': 3, 'T': 1, 'V': 2}</p>
 * <p>For order VGS, Monica can make a team in 2<em>2</em>3 = 12 ways.
 * After 1st order we decrement 1 employee each from V, G and ; so available number of employees are:
 * {'B': 2, 'G': 1, 'N': 1, 'P': 0, 'S': 2, 'T': 1, 'V': 1}</p>
 * <p>For order NTS, there are 1<em>1</em>2 = 2 ways.
 * After 2nd order, available employees are:
 * {'B': 2, 'G': 1, 'N': 0, 'P': 0, 'S': 1, 'T': 0, 'V': 1}</p>
 * <p>For order NGS, since number of employees for 'N' is 0, we cannot prepare a team even though the other employees for 'G' and 'S'. So the answer is zero. Since the team is not formed we don't decrement the number for 'G' and 'S'.
 * After 3rd order, available employees are again:
 * {'B': 2, 'G': 1, 'N': 0, 'P': 0, 'S': 1, 'T': 0, 'V': 1}</p>
 * <p>For order VGS, there is 1<em>1</em>1 = 1 way.
 * Similarly we can find for order VGB as well. </p>
 *
 * Algorithms
 * =========
 * 1. Construct a histogram from given S1
 * 2. For each S2, check if chefs can be selected.
 */
public class HeadChefMonica {


    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }


    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int N = nextInt();
        char[] sArray = next().toCharArray();
        int[] hist = new int[26];
        for (char c : sArray) {
            hist[c - 'A']++;
        }

        int M = nextInt();


        for (int i = 0; i < M; i++) {
            char[] s2Array = next().toCharArray();
            long answer = 1L;
            if (hist[s2Array[0] - 'A'] != 0 && hist[s2Array[1] - 'A'] != 0 && hist[s2Array[2] - 'A'] != 0) {
                answer = answer * hist[s2Array[0] - 'A'] * hist[s2Array[1] - 'A'] * hist[s2Array[2] - 'A'];
                hist[s2Array[0] - 'A']--;
                hist[s2Array[1] - 'A']--;
                hist[s2Array[2] - 'A']--;
                pw.println(answer % 1000000007);
            } else {
                pw.println(0);
            }
        }

        reader.close();
        pw.close();
    }


}
