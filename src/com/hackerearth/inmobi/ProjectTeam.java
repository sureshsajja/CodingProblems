package com.hackerearth.inmobi;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 04/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/project-team/
 */
public class ProjectTeam {

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
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = nextInt();
            }
            Arrays.sort(array);
            int minTeam = Integer.MAX_VALUE;
            int maxTeam = Integer.MIN_VALUE;
            for (int i = 0, j = N - 1; i < j; i++, j--) {
                int team = array[i] + array[j];
                if (team < minTeam) {
                    minTeam = team;
                }
                if (team > maxTeam) {
                    maxTeam = team;
                }
            }

            pw.println(maxTeam - minTeam);
        }


        reader.close();
        pw.close();
    }
}
