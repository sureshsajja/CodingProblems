/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.hackerearth.codex;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  08/09/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/problem/algorithm/paint-the-cars
 * <p>
 * * Optimal Sub-structure
 * =====================
 * minCost(i, R, G, B) = min{
 * cost(R) + minCost(i-1, G, B),
 * cost(G) + minCost(i-1, R, B),
 * cost(B) + minCost(i-1, R, G)
 * }
 * <p>
 * <p>
 * table[i][R] = min{
 * cost(G) + table[index - 1][G],
 * cost(B) + table[index - 1][B]
 * }
 * <p>
 * table[i][G] = min{
 * cost(R) + table[index - 1][R],
 * cost(B) + table[index - 1][B]
 * }
 * <p>
 * table[i][B] = min{
 * cost(R) + table[index - 1][R],
 * cost(B) + table[index - 1][B]
 * }
 */
public class PaintTheCarsDP {

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
            int[][] cost = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    cost[i][j] = nextInt();
                }
            }
            pw.println(findMinCost(cost, N));
        }
        reader.close();
        pw.close();
    }

    private static int findMinCost(int[][] cost, int N) {

        int[][] table = new int[N][3];

        int i = cost[0][0];
        int j = cost[0][1];
        int k = cost[0][2];

        table[0][0] = j > k ? k : j;
        table[0][1] = i > k ? k : i;
        table[0][2] = i > j ? j : i;


        for (int index = 1; index < N; index++) {
            i = cost[index][0] + table[index - 1][0];
            j = cost[index][1] + table[index - 1][1];
            k = cost[index][2] + table[index - 1][2];

            table[index][0] = j > k ? k : j;
            table[index][1] = i > k ? k : i;
            table[index][2] = i > j ? j : i;
        }

        i = table[N - 1][0];
        j = table[N - 1][1];
        k = table[N - 1][2];

        return compare(i, j, k);

    }

    private static int compare(int i, int j, int k) {

        if (i < j) {
            if (i < k) {
                return i;
            } else {
                return k;
            }
        } else if (j < k) {
            return j;
        } else {
            return k;
        }
    }


}
