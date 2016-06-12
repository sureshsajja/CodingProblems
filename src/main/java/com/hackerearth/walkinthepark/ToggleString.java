package com.hackerearth.walkinthepark;

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
 * ssajja 12-06-2016
 */
public class ToggleString {

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

        String s = next();

        char[] chars = s.toCharArray();
        int i = 0;
        for (char c : chars) {
            if ('a' <= c && 'z' >= c) {
                chars[i] = (char) (c - 'a' + 'A');
            } else if ('A' <= c && 'Z' >= c) {
                chars[i] = (char) (c - 'A' + 'a');
            }
            i++;
        }

        pw.println(new String(chars));

        pw.close();
        reader.close();

    }
}
