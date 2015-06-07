package com.hackerearth.hacktheslack;

/**
 * Author : Suresh
 * Date : 07/06/15.
 */

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerearth.com/problem/algorithm/karan-and-strings/
 */
public class KaranAndStrings {

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
            pw.println(trim(s.toCharArray()));
        }


        reader.close();
        pw.close();
    }

    private static String trim(char[] chars) {

        char[] _trim = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            _trim[i] = ' ';
        }

        char prev = ' ';
        int i = 0;
        for (char c : chars) {
            if (c != prev) {
                _trim[i++] = c;
                prev = c;
            }
        }


        return new String(_trim).trim();
    }

}
