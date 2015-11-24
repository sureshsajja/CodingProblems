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

package com.hackerearth.thoughtworks;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  12/07/15
 * Version : v1
 */
public class MarutAndStrings {

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
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T;
        try {
            T = nextInt();
        } catch (RuntimeException e) {
            T = 0;
        }
        if (T < 1 || T > 10) {
            pw.println("Invalid Test");
        } else {
            for (int t = 0; t < T; t++) {
                String s = next();
                int number = findMinOperations(s.toCharArray());
                if (number == -1) {
                    pw.println("Invalid Input");
                } else {
                    pw.println(number);
                }
            }
        }


        reader.close();
        pw.close();
    }

    private static int findMinOperations(char[] chars) {

        if (chars.length < 1 || chars.length > 100) {
            return -1;
        }

        int upperCase = 0;
        int lowerCase = 0;
        for (char c : chars) {
            if (isLowerCase(c))
                lowerCase++;
            else if (isUppercase(c))
                upperCase++;
        }


        if (upperCase == 0 && lowerCase == 0) {
            return -1;
        }
        if (upperCase > lowerCase) {
            return lowerCase;
        } else
            return upperCase;

    }

    private static boolean isUppercase(char c) {
        return (c >= 'A' && c <= 'Z');
    }

    private static boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }
}
