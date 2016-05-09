package com.coderevisited.math.utils;

/**
 * ssajja 09-05-2016
 */

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
 * Calculates (a^b)%c for int
 */
public class Modulo {

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

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int i = 0; i < T; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            pw.println(calculateModulo(a, b, c));
        }

        pw.close();
        reader.close();
    }

    public static int calculateModulo(int a, int b, int c) {

        long result = 1, base = a;
        while (b > 0) {
            if (b % 2 == 1) {
                result = (result * base) % c;
            }
            base = (base * base) % c;
            b >>>= 1;
        }
        return (int) (result % c);
    }

}
