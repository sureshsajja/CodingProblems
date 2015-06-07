package com.spoj;

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
 * http://www.spoj.com/problems/ADDREV/
 */
public class ADDREV {

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
            int a = nextInt();
            int b = nextInt();
            pw.println(reverse(reverse(a) + reverse(b)));
        }


        reader.close();
        pw.close();
    }

    private static int reverse(int number) {

        int reverseNumber = 0;
        while (number > 0) {
            int reminder = number % 10;
            reverseNumber = reverseNumber * 10 + reminder;
            number = number / 10;
        }
        return reverseNumber;

    }
}
