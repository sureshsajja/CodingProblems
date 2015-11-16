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

package com.hackerearth.codemonk.graphtheory;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * User :  Suresh
 * Date :  02/07/15
 * Version : v1
 */
public class KingdomOfMonkeys {

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
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int T = nextInt();
        for (int t = 0; t < T; t++) {

            int V = nextInt();
            int E = nextInt();
            List<List<Integer>> adjacencyList = new ArrayList<>();
            adjacencyList.add(new ArrayList<Integer>());
            for (int v = 0; v < V; v++) {
                adjacencyList.add(new ArrayList<Integer>());
            }

            for (int e = 0; e < E; e++) {
                int u = nextInt();
                int v = nextInt();
                adjacencyList.get(u).add(v);
                adjacencyList.get(v).add(u);
            }

            long[] weight = new long[V + 1];
            for (int v = 1; v <= V; v++) {
                weight[v] = nextLong();
            }

            boolean[] visted = new boolean[V + 1];
            long max = 0;
            for (int v = 1; v <= V; v++) {
                long current = 0;
                if (!visted[v]) {

                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(v);
                    while (!queue.isEmpty()) {
                        int top = queue.poll();
                        current += weight[top];
                        visted[top] = true;
                        List<Integer> list = adjacencyList.get(top);
                        for (Integer i : list) {
                            if (!visted[i]) {
                                queue.add(i);
                                visted[i] = true;
                            }
                        }
                    }
                }
                if (current > max) {
                    max = current;
                }


            }
            pw.println(max);

        }


        reader.close();
        pw.close();
    }


}
