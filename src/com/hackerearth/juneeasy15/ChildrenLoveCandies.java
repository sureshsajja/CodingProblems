package com.hackerearth.juneeasy15;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 01/06/15.
 */

/**
 * https://www.hackerearth.com/june-easy-15/algorithm/children-love-candies/
 */
public class ChildrenLoveCandies {

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

        int Q = nextInt();
        for (int q = 0; q < Q; q++) {
            long N = nextLong();
            int T = nextInt();
            for (int t = 0; t < T; t++) {
                N = consumeForDay(N);
            }
            pw.println(N);
        }


        reader.close();
        pw.close();
    }

    private static long consumeForDay(long n) {

        n = consumeAt9AM(n);
        n = consumeAt10AM(n);
        return n;
    }

    private static long consumeAt9AM(long n) {
        return n / 2;
    }

    private static long consumeAt10AM(long n) {
        return n - (n / 4);
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}
