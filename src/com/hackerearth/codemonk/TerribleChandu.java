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
 * https://www.hackerearth.com/code-monk-array-strings/algorithm/terrible-chandu/
 */
public class TerribleChandu {

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
            pw.println(reverse(s));
        }


        reader.close();
        pw.close();
    }

    private static String reverse(String s) {
        char[] _reverse = new char[s.length()];
        int i = s.length() - 1;
        for (char c : s.toCharArray()) {
            _reverse[i--] = c;
        }
        return new String(_reverse);
    }
}
