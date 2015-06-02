package com.hackerearth.mayeasy14;

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
 * https://www.hackerearth.com/may-easy-challenge-14/algorithm/abed-and-timelines/
 */
public class AbedAndTimelines {

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
            int x1 = nextInt();
            int y1 = nextInt();
            int x2 = nextInt();
            int y2 = nextInt();
            int cost = nextInt();

            int totalCost = calculateCostFor(x2, x1, N, cost) + calculateCostFor(y2, y1, M, cost);
            pw.println(totalCost);
            if (totalCost > 1000) {
                pw.println("Let go of the group.");
            } else {
                pw.println("You saved the group.");
            }

        }


        reader.close();
        pw.close();
    }

    private static int calculateCostFor(int i, int j, int n, int cost) {
        int a = Math.abs(i - j);
        int b = Math.abs(n - a);
        return a > b ? b * cost : a * cost;

    }
}
