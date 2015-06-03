package com.hackerearth.septembereasy14;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 03/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/crazy-kangaroo/
 */
public class Crazykangaroo {

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
        return parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            long A = nextLong();
            long B = nextLong();
            long M = nextLong();

            long start;
            if (A % M == 0) {
                start = A / M;
            } else {
                start = A / M + 1;
            }

            long end = B / M;


            if (end - start > 0)
                pw.println(end - start + 1);
            else
                pw.println(0);

        }


        reader.close();
        pw.close();
    }
}
