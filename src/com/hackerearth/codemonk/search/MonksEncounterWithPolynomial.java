package com.hackerearth.codemonk.search;

/**
 * Author : Suresh
 * Date : 11/06/15.
 */

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerearth.com/code-monk-searching/algorithm/monks-encounter-with-polynomial/
 */
public class MonksEncounterWithPolynomial {

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

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();

        for (int t = 0; t < T; t++) {
            long a = nextLong();
            long b = nextLong();
            long c = nextLong();
            long k = nextLong();
            double delta = calculateDelta(a, b, c - k) - b;
            if (delta < 0)
                delta = 0;
            pw.println((int) Math.ceil(delta / (2 * a)));
        }


        reader.close();
        pw.close();
    }

    private static double calculateDelta(long a, long b, long c) {

        return Math.sqrt(b * b - 4 * a * c);
    }
}
