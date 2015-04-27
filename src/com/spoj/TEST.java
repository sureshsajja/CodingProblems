package com.spoj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * http://www.spoj.com/problems/TEST/
 */
public class TEST {
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
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        boolean process = true;
        while (process) {
            int i = nextInt();
            if (i == 42) {
                process = false;
            }

            if (process) {
                pw.println(i);
            }
        }


        reader.close();
        pw.close();

    }
}
