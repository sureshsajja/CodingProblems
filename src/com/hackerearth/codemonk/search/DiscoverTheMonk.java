package com.hackerearth.codemonk.search;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 11/06/15.
 */

/**
 * https://www.hackerearth.com/code-monk-searching/algorithm/discover-the-monk/
 */
public class DiscoverTheMonk {

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
        int Q = nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = nextInt();
        }

        Arrays.sort(array);

        for (int q = 0; q < Q; q++) {
            int x = nextInt();
            if (Arrays.binarySearch(array, x) >= 0) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }


        reader.close();
        pw.close();
    }
}
