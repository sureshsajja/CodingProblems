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
 */

package com.codejam2016.round1b;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 30/04/16
 * Version : v1
 */
public class GettingTheDigits {


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

        int T = nextInt();

        for (int t = 0; t < T; t++) {
            String s = next();

            int[] hist = new int[26];
            for (char c : s.toCharArray()) {
                hist[c - 'A']++;
            }

            StringBuilder sb = new StringBuilder();
            while (hist['Z' - 'A'] > 0 && hist['E' - 'A'] > 0 && hist['R' - 'A'] > 0 && hist['O' - 'A'] > 0) {
                hist['Z' - 'A']--;
                hist['E' - 'A']--;
                hist['R' - 'A']--;
                hist['O' - 'A']--;
                sb.append(0);
            }

            while (hist['T' - 'A'] > 0 && hist['W' - 'A'] > 0 && hist['O' - 'A'] > 0) {
                hist['T' - 'A']--;
                hist['W' - 'A']--;
                hist['O' - 'A']--;
                sb.append(2);
            }

            while (hist['F' - 'A'] > 0 && hist['O' - 'A'] > 0 && hist['U' - 'A'] > 0 && hist['R' - 'A'] > 0) {
                hist['F' - 'A']--;
                hist['O' - 'A']--;
                hist['U' - 'A']--;
                hist['R' - 'A']--;
                sb.append(4);
            }

            while (hist['S' - 'A'] > 0 && hist['I' - 'A'] > 0 && hist['X' - 'A'] > 0) {
                hist['S' - 'A']--;
                hist['I' - 'A']--;
                hist['X' - 'A']--;
                sb.append(6);
            }

            while (hist['E' - 'A'] > 0 && hist['I' - 'A'] > 0 && hist['G' - 'A'] > 0 && hist['H' - 'A'] > 0 && hist['T' - 'A'] > 0) {
                hist['E' - 'A']--;
                hist['I' - 'A']--;
                hist['G' - 'A']--;
                hist['H' - 'A']--;
                hist['T' - 'A']--;
                sb.append(8);
            }



            while (hist['F' - 'A'] > 0 && hist['I' - 'A'] > 0 && hist['V' - 'A'] > 0 && hist['E' - 'A'] > 0) {
                hist['F' - 'A']--;
                hist['I' - 'A']--;
                hist['V' - 'A']--;
                hist['E' - 'A']--;
                sb.append(5);
            }

            while (hist['S' - 'A'] > 0 && hist['E' - 'A'] > 1 && hist['V' - 'A'] > 0 && hist['N' - 'A'] > 0) {
                hist['S' - 'A']--;
                hist['E' - 'A']--;
                hist['V' - 'A']--;
                hist['E' - 'A']--;
                hist['N' - 'A']--;
                sb.append(7);
            }



            while (hist['T' - 'A'] > 0 && hist['H' - 'A'] > 0 && hist['R' - 'A'] > 0 && hist['E' - 'A'] > 1) {
                hist['T' - 'A']--;
                hist['H' - 'A']--;
                hist['R' - 'A']--;
                hist['E' - 'A']--;
                hist['E' - 'A']--;
                sb.append(3);
            }


            while (hist['O' - 'A'] > 0 && hist['N' - 'A'] > 0 && hist['E' - 'A'] > 0) {
                hist['O' - 'A']--;
                hist['N' - 'A']--;
                hist['E' - 'A']--;
                sb.append(1);
            }


            while (hist['N' - 'A'] > 1 && hist['I' - 'A'] > 0 && hist['E' - 'A'] > 0) {
                hist['N' - 'A']--;
                hist['I' - 'A']--;
                hist['N' - 'A']--;
                hist['E' - 'A']--;
                sb.append(9);
            }

            char[] array = sb.toString().toCharArray();
            Arrays.sort(array);

            pw.println("Case #" + (t + 1) + ": " + new String(array));
            for (int i : hist) {
                if (i != 0)
                    pw.println("Error " + s);

            }

        }

        reader.close();
        pw.close();

    }


}
