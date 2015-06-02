package com.hackerearth.thoughtworks;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerearth.com/problem/algorithm/the-best-internet-browser-3/
 */
public class TheBestInternetBrowser {

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
            String[] parts = s.split("\\.");
            int count = countConsonents(parts[1].toCharArray());
            pw.println((count + 4) + "/" + s.length());
        }


        reader.close();
        pw.close();
    }

    private static int countConsonents(char[] chars) {
        int count = 0;
        for (char c : chars) {
            if (c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u') {
                count++;
            }
        }
        return count;
    }
}
