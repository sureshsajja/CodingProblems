package com.hackerearth.codemonk;

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
 * https://www.hackerearth.com/code-monk-array-strings/algorithm/chandu-and-consecutive-letters/
 */
public class ChanduAndConsecutiveLetters {

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
            pw.println(trim(s));
        }


        reader.close();
        pw.close();
    }

    private static String trim(String s) {
        char[] _chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            _chars[i] = ' ';
        }
        char prevChar = ' ';
        int i = 0;
        for (char c : s.toCharArray()) {
            if (c != prevChar) {
                _chars[i++] = c;
                prevChar = c;
            }
        }

        return new String(_chars).trim();
    }
}
