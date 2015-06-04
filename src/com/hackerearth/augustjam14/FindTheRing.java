package com.hackerearth.augustjam14;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 04/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/find-the-ring/
 */
public class FindTheRing {

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
            int index = nextInt();
            int N = nextInt();

            if (N == 0) {
                pw.println(index);
            } else if (index == 0 || index == 2) {
                if (N % 2 == 0) {
                    pw.println(0);
                } else
                    pw.println(1);

            } else {
                if (N % 2 == 0) {
                    pw.println(1);
                } else
                    pw.println(0);
            }
        }


        reader.close();
        pw.close();
    }
}
