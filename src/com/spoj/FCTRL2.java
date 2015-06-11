package com.spoj;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 10/06/15.
 */

/**
 * http://www.spoj.com/problems/FCTRL2/
 */
public class FCTRL2 {

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
            int N = nextInt();
            calculateFactorial(N, pw);
        }


        reader.close();
        pw.close();
    }

    private static void calculateFactorial(int n, PrintWriter pw) {

        int[] result = new int[160];
        result[0] = 1;
        int size = 1;
        for (int i = 2; i <= n; i++) {
            size = multiply(result, size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            pw.print(result[i]);
        }
        pw.println();
    }

    private static int multiply(int[] result, int size, int i) {
        int carry = 0;
        for (int j = 0; j < size; j++) {
            int prod = result[j] * i + carry;
            result[j] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            result[size] = carry % 10;
            carry = carry / 10;
            size++;
        }
        return size;

    }
}
