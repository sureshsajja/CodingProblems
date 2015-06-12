package com.hackerearth.septembereasy14;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 13/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/alien-language/
 */
public class AlienLanguage {

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
            String text = next();
            Set<Character> characterSet = new HashSet<>();
            for (char c : text.toCharArray()) {
                characterSet.add(c);
            }
            boolean found = false;
            String pattern = next();
            for (char c : pattern.toCharArray()) {
                if (characterSet.contains(c)) {
                    found = true;
                    break;
                }
            }


            if (found) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }


        reader.close();
        pw.close();
    }
}
