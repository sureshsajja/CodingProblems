package com.hackerearth.easy;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/day-6-advanced-mathematics/
 */
public class DateWithAvni {

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
            char prev = '-';
            boolean nonRepeated = true;
            for (char c : s.toCharArray()) {
                if (c == prev) {
                    pw.println("SLAP");
                    nonRepeated = false;
                    break;
                } else {
                    prev = c;
                }
            }
            if (nonRepeated) {
                pw.println("KISS");
            }
        }


        reader.close();
        pw.close();
    }
}
