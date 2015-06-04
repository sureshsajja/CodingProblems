package com.hackerearth.kuliza;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 04/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/2-fast-2-furious/
 */
public class TwoFastTwoFurious {

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
        int[] dom = new int[N];
        int[] brian = new int[N];

        int domMax = 0;
        int prev = 0;
        for (int i = 0; i < N; i++) {
            dom[i] = nextInt();
            int diff = Math.abs(dom[i] - prev);
            if (diff > domMax) {
                domMax = diff;
            }
            prev = dom[i];
        }

        int brianMax = 0;
        prev = 0;
        for (int i = 0; i < N; i++) {
            brian[i] = nextInt();
            int diff = Math.abs(brian[i] - prev);
            if (diff > brianMax) {
                brianMax = diff;
            }
            prev = brian[i];
        }

        if (brianMax > domMax) {
            pw.println("Brian");
            pw.println(brianMax);
        } else if (brianMax < domMax) {
            pw.println("Dom");
            pw.println(domMax);
        } else {
            pw.println("Tie");
            pw.println(domMax);
        }


        reader.close();
        pw.close();
    }
}
