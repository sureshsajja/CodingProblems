package com.hackerearth.easy;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 12/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/pattern/
 */
public class Pattern {

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

        int n = nextInt();
        for (int i = 0; i < n; i++) {
            pw.print("*");
        }
        pw.println();

        int j = n - 1;
        while (j > 1) {
            for (int i = 1; i < j; i++) {
                pw.print(" ");
            }
            pw.println("*");

            j--;
        }
        for (int i = 0; i < n; i++) {
            pw.print("*");
        }
        pw.println();


        reader.close();
        pw.close();
    }
}
