package com.hackerearth.bigbang;

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
 * ssajja 14-06-2016
 */

/**
 * https://www.hackerearth.com/problem/algorithm/subset-and-4/
 * If AND of two numbers in a set is '0' then AND of set is 0
 */
public class SubsetAND {

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
        for (int t = 0; t < T; t++) {
            int Z = nextInt();
            int N = nextInt();
            int[] array = new int[N];
            for (int i = 0; i < N; i++) {
                array[i] = nextInt();
            }
            boolean found = false;
            int overallAND = Z;
            for (int i = 0; i < N; i++) {
                overallAND &= array[i];
                if (overallAND == 0) {
                    found = true;
                    break;
                }
            }
            if (found) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }
        pw.close();
        reader.close();
    }

}
