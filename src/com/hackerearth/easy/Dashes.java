package com.hackerearth.easy;

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
 * https://www.hackerearth.com/problem/algorithm/what-is-the-string-made-of-2/
 */
public class Dashes {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static int[] dashes = new int[10];

    static {
        dashes[0] = 6;
        dashes[1] = 2;
        dashes[2] = 5;
        dashes[3] = 5;
        dashes[4] = 4;
        dashes[5] = 5;
        dashes[6] = 6;
        dashes[7] = 3;
        dashes[8] = 7;
        dashes[9] = 6;
    }

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

        String s = next();
        int total = 0;
        for (char c : s.toCharArray()) {
            total += dashes[c - '0'];
        }
        pw.println(total);


        reader.close();
        pw.close();
    }

}
