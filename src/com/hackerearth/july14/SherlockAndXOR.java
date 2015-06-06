package com.hackerearth.july14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 06/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/sherlock-and-xor/
 */
public class SherlockAndXOR {

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
            List<Integer> even = new ArrayList<>();
            List<Integer> odd = new ArrayList<>();
            int N = nextInt();
            for (int i = 0; i < N; i++) {
                int a = nextInt();
                if ((a & 1) == 1) {
                    odd.add(a);
                } else
                    even.add(a);
            }
            long mul = 1;
            mul = mul * even.size() * odd.size();

            pw.println(mul);

        }


        reader.close();
        pw.close();
    }
}
