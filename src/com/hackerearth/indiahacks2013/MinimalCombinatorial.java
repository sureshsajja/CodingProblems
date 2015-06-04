package com.hackerearth.indiahacks2013;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 03/06/15.
 */

/**
 * https://www.hackerearth.com/problem/golf/minimal-combinatorial/
 */
public class MinimalCombinatorial {

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

            long n = nextLong();
            long r = nextLong();

            BigInteger value = BigInteger.ONE;
            for (long i = n; i > (n - r); i--) {
                value = value.multiply(BigInteger.valueOf(i));
            }
            for (long i = r; i > 0; i--) {
                value = value.divide(BigInteger.valueOf(i));
            }
            pw.println(value.toString());

        }


        reader.close();
        pw.close();
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

}
