package com.hackerearth.iitkgp;

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
 * https://www.hackerearth.com/problem/algorithm/day-3-1-d-arrays/
 */
public class BabaiAndDiti {

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
            int[] firstPos = new int[10];
            int[] lastPos = new int[10];
            for (int i = 0; i < 10; i++) {
                firstPos[i] = -1;
                lastPos[i] = -1;
            }

            for (int n = 0; n < N; n++) {
                int i = nextInt();
                if (firstPos[i] == -1) {
                    firstPos[i] = n;
                }
                lastPos[i] = n;

            }

            int MAX = Integer.MIN_VALUE;
            for (int i = 0; i < 10; i++) {
                if (firstPos[i] != -1 && lastPos[i] != -1) {
                    int diff = lastPos[i] - firstPos[i] + 1;
                    if (diff > MAX) {
                        MAX = diff;
                    }
                }
            }
            pw.println(MAX);

        }


        reader.close();
        pw.close();
    }
}
