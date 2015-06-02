package com.hackerearth.easy;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/fizzbuzz/
 */
public class FizzBuzzTest {

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

        for (int i = 1; i < 101; i++) {

            if (i % 3 == 0) {
                if (i % 5 == 0) {
                    pw.println("FizzBuzz");
                } else {
                    pw.println("Fizz");
                }
            } else if (i % 5 == 0) {
                pw.println("Buzz");
            } else {
                pw.println(i)
                ;
            }

        }


        reader.close();
        pw.close();
    }
}
