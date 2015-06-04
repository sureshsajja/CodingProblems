package com.hackerearth.codemonk;

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
 * https://www.hackerearth.com/code-monk-array-strings/algorithm/prateek-and-his-friends/
 */
public class PrateekAndHisFriends {

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

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int N = nextInt();
            long X = nextLong();
            long[] array = new long[N];
            for (int i = 0; i < N; i++) {
                array[i] = nextLong();
            }

            int leaving = 0;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (sum == X) {
                    break;
                }
                sum += array[i];
                while (sum > X) {
                    sum -= array[leaving];
                    leaving++;
                }
            }
            if (sum == X) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        reader.close();
        pw.close();
    }
}
