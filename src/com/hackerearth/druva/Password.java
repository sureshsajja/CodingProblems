package com.hackerearth.druva;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 03/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/password-1/
 */
public class Password {

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

        int N = nextInt();

        Set<String> set = new HashSet<>();
        for (int n = 0; n < N; n++) {
            set.add(next());
        }

        for (String s : set) {
            String _reverse = reverse(s);
            if (set.contains(_reverse)) {
                pw.print(s.length() + " ");
                char[] chars = s.toCharArray();
                pw.println(chars[s.length() / 2]);
                break;
            }
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
