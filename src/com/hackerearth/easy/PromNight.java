package com.hackerearth.easy;

/**
 * Author : Suresh
 * Date : 07/06/15.
 */

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * https://www.hackerearth.com/problem/algorithm/prom-night/
 */
public class PromNight {

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
            int M = nextInt();
            int[] boys = new int[N];
            int[] girls = new int[M];
            for (int n = 0; n < N; n++) {
                boys[n] = nextInt();
            }
            for (int m = 0; m < M; m++) {
                girls[m] = nextInt();
            }

            if (boys.length > girls.length) {
                pw.println("NO");
            } else {
                Arrays.sort(boys);
                Arrays.sort(girls);

                int girlIndex = 0;
                boolean foundAll = true;
                for (int i = 0; i < N; i++) {
                    int boy = boys[i];
                    boolean found = false;
                    while (girlIndex < M) {
                        if (boy > girls[girlIndex]) {
                            found = true;
                            girlIndex++;
                            break;
                        }
                        girlIndex++;

                    }
                    if (!found) {
                        pw.println("NO");
                        foundAll = false;
                        break;
                    }
                }
                if (foundAll) {
                    pw.println("YES");
                }
            }


        }


        reader.close();
        pw.close();
    }
}
