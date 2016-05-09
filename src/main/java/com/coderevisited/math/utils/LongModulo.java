package com.coderevisited.math.utils;

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
 * ssajja 09-05-2016
 */
public class LongModulo {

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
            long a = nextLong();
            long b = nextLong();
            long c = nextLong();
            pw.println(modulo(a, b, c));
        }

        pw.close();
        reader.close();

    }

    private static long modulo(long a, long b, long c) {

        long result = 1, base = a;
        while (b > 0) {
            if (b % 2 == 1) {
                result = mulModulo(result, base, c);
            }
            base = mulModulo(base, base, c);
            b >>>= 1;
        }
        return (int) (result % c);
    }

    private static long mulModulo(long a, long b, long c) {
        long result = 0, base = a % c;
        while (b > 0) {

            if (b % 2 == 1) {
                result = (result + base) % c;
            }
            base = (base * 2) % c;
            b >>>= 1;
        }
        return result % c;
    }
}
