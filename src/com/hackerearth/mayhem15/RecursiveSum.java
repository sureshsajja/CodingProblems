package com.hackerearth.mayhem15;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 31/05/15.
 */

/**
 * https://www.hackerearth.com/may-hem-15/algorithm/recursive-sums/
 */
public class RecursiveSum {


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

        int N = nextInt();
        for (int n = 0; n < N; n++) {
            int M = nextInt();
            long answer = 0;
            for (int m = 0; m < M; m++) {
                long len = nextLong();
                long compressed = compress(len);
                int d = nextInt();
                compressed = compress(d * compressed);
                answer = compress(compressed + answer);

            }
            pw.println(answer);
        }


        reader.close();
        pw.close();
    }

    public static long compress(long l) {
        long compressed = 0;
        while (l > 0) {
            long i = l % 10;
            compressed += i;
            if (compressed > 9) {
                compressed = compress(compressed);
            }
            l = l / 10;
        }
        return compressed;
    }

}
