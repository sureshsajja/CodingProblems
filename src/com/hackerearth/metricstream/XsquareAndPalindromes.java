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
import java.math.BigInteger;
import java.util.Scanner;

/**
 * User : Suresh
 * Date : 28/03/15
 */

/**
 * Xsquare get bored playing with the arrays all the time. So,he decided to buy a new character set to play with. Xsquare's character set contains only lower case alphabets more specifically characters from 'a' to 'z' (both inclusive). Xsquare was playing with this new character set and formed some interesting continuous sequences of characters.
 * <p/>
 * for ex :
 * <p/>
 * ioi
 * cheffehc
 * bab
 * codeedoc
 * radar
 * Xsquare called this sequences interesting as these sequences remains same even after reversing. Come on , you are already familiar with these sequences. If in case you are not. Please, Have a look at this link
 * <p/>
 * Fascinated with these sequences, Xsquare starts thinking how many distinct interesting sequences of length N are possible if he would have infinite number of each character in the character set.
 * <p/>
 * Xsquare thinks he is very good at counting and starts counting the number of such sequences for a given length N on his fingers.
 * <p/>
 * Can you help him by verifying his answer. Please calculate the number of sequences modulo (109 + 9)
 * <p/>
 * Input
 * <p/>
 * First line of input contains a single integer T denoting the number of test cases. First and only line of each test case contains a single integer N denoting the length of the sequences.
 * <p/>
 * Output
 * <p/>
 * Output consists of **T** lines, one line per test cases containing the required answer.
 * <p/>
 * Constraints
 * <p/>
 * 1<=T<=105
 * 1<=N<=1018
 * <p/>
 * Input
 * =====
 * 2
 * 1
 * 2
 * <p/>
 * Output
 * =====
 * 26
 * 26
 * <p/>
 * <p/>
 * Solution
 * =======
 * It is asked that how many palindromic words are possible with n letters
 * Formula: 26 ^ n/2 if n is even
 * 26 ^ (n+1)/2 if n odd.
 * <p/>
 * Since computation can overflow integer rage, we have MOD it with 10^9+9
 */
public class XsquareAndPalindromes {


    private static BigInteger TWOSIX = BigInteger.valueOf(26);
    private static BigInteger MOD = BigInteger.valueOf(1000000009);


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long i = scanner.nextLong();
            if (i == 1)
                pw.println(26);
            else if (i == 2)
                pw.println(26);
            else if (i % 2 == 0) {
                pw.println(findPowerWith26((i / 2)));
            } else {
                pw.println(findPowerWith26(((i + 1) / 2)));
            }

        }

        scanner.close();
        pw.close();
    }

    private static int findPowerWith26(long i) {
        return TWOSIX.modPow(BigInteger.valueOf(i), MOD).intValue();

    }


}
