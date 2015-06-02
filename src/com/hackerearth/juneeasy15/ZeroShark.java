package com.hackerearth.juneeasy15;

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
 * https://www.hackerearth.com/june-easy-15/algorithm/zeroshark/
 */
public class ZeroShark {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static long MOD = 1000000007;
    private static long[] fib = new long[100001];
    private static long[] counter = new long[100001];

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

        calculateFib();
        calculateCounters();
        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int N = nextInt();
            pw.println(counter[N]);
        }


        reader.close();
        pw.close();
    }


    private static void calculateFib() {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i < 100001; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }
    }

    private static void calculateCounters() {
        counter[2] = 1;
        counter[3] = 2;
        for (int i = 4; i < 100001; i++) {
            counter[i] = (counter[i - 1] + counter[i - 2] + fib[i - 1]) % MOD;
        }
    }


}
