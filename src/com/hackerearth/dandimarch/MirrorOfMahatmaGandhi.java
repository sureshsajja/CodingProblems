package com.hackerearth.dandimarch;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 07/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/mirror-of-mahatma-gandhi/
 */
public class MirrorOfMahatmaGandhi {

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
        for (int i = 0; i < T; i++) {
            String next = next();
            if (checkIfonly180(next.toCharArray())) {
                if (reverse(next.toCharArray()).equals(next)) {
                    pw.println("YES");
                } else {
                    pw.println("NO");
                }
            } else {
                pw.println("NO");
            }
        }


        reader.close();
        pw.close();
    }

    private static boolean checkIfonly180(char[] chars) {
        for (char c : chars) {
            if (c != '1' && c != '8' && c != '0') {
                return false;
            }
        }
        return true;
    }

    private static String reverse(char[] chars) {
        char[] _reverse = new char[chars.length];
        int i = chars.length - 1;
        for (char c : chars) {
            _reverse[i--] = c;
        }
        return new String(_reverse);
    }
}
