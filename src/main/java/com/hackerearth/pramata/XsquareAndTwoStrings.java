package com.hackerearth.pramata;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 13-06-2016
 */

/**
 * https://www.hackerearth.com/problem/algorithm/xsquare-and-two-strings-1/
 */
public class XsquareAndTwoStrings {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
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
            String s1 = next();
            String s2 = next();
            boolean found = false;
            for (char c : s1.toCharArray()) {
                if (s2.indexOf(c) != -1) {
                    found = true;
                    break;
                }
            }
            if (found) {
                pw.println("Yes");
            } else
                pw.println("No");
        }
        pw.close();
        reader.close();

    }
}
