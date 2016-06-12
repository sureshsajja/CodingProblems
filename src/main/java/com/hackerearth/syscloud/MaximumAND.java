package com.hackerearth.syscloud;

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
 * https://www.hackerearth.com/problem/algorithm/maximum-and/
 */
public class MaximumAND {

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

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            long A = nextLong();
            long B = nextLong();
            long result = 0L;

            if (B - A == 1) {
                //If both are adjacent
                result = B & A;
            } else if (ifPowOfTwo(B)) {
                //If B is power of two, B-1&B-2
                result = B - 2;
            } else if (B % 2 == 1) {
                //other cases , if B is odd B & B-1 = B-1
                result = B - 1;
            } else {
                //if B is even , B & B-1 = B-2
                result = B - 2;
            }

            pw.println(result);
        }

        pw.close();
        reader.close();

    }

    private static boolean ifPowOfTwo(long n) {
        return n > 0 && (n & n - 1) == 0;
    }
}
