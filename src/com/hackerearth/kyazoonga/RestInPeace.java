package com.hackerearth.kyazoonga;

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
 * https://www.hackerearth.com/problem/algorithm/rest-in-peace-21-1/
 */
public class RestInPeace {

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
            if (s.contains("21")) {
                pw.println("The streak is broken!");
            } else {
                int n = Integer.parseInt(s);
                if (n % 21 == 0) {
                    pw.println("The streak is broken!");
                } else {
                    pw.println("The streak lives still in our heart!");
                }
            }
        }


        reader.close();
        pw.close();
    }
}
