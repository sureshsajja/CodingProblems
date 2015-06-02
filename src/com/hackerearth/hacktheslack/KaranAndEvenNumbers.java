package com.hackerearth.hacktheslack;

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
 * https://www.hackerearth.com/problem/algorithm/karan-and-even-numbers-1/
 */
public class KaranAndEvenNumbers {

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

        int i = nextInt();
        while (i != -1) {
            if (i % 2 == 0) {
                pw.println(i);
            }
            i = nextInt();
        }

        reader.close();
        pw.close();
    }
}
