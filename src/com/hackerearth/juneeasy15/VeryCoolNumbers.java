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
 * https://www.hackerearth.com/problem/algorithm/very-cool-numbers/
 */
public class VeryCoolNumbers {


    private static int[] coolness = new int[100001];
    private static int BASE = 5;
    private static int MASK = 7;

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


        calculateCoolness();
        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int R = nextInt();
            int k = nextInt();
            int veryCool = 0;
            for (int i = 1; i <= R; i++) {
                if (coolness[i] >= k) {
                    veryCool++;
                }
            }
            pw.println(veryCool);
        }

        reader.close();
        pw.close();
    }

    private static void calculateCoolness() {

        int base = BASE;
        int mask = MASK;
        while (base < 100001) {
            for (int i = 1; i < 100001; i++) {

                if ((i & mask) == base) {
                    coolness[i]++;
                }
            }
            base = base << 1;
            mask = mask << 1;
        }
    }
}
