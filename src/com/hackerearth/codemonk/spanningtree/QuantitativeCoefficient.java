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

package com.hackerearth.codemonk.spanningtree;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  29/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/problem/algorithm/quantitative-coefficient/
 */
public class QuantitativeCoefficient {
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] parent;
    private static final int MOD = 1000000007;

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
            PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
            for (int m = 0; m < M; m++) {
                int u = nextInt();
                int v = nextInt();
                int w = nextInt();
                Edge e = new Edge(u, v, w);
                edges.add(e);
            }

            parent = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                parent[i] = i;
            }


            long total = 1L;
            int numEdges = 0;
            while (!edges.isEmpty()) {
                Edge e = edges.poll();
                if (!connected(e.v, e.u)) {
                    total *= e.w;
                    total %= MOD;
                    union(e.v, e.u);
                    numEdges++;
                }
                if (numEdges == N - 1)
                    break;
            }
            pw.println(total);
        }


        reader.close();
        pw.close();
    }

    public static int find(int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
    }

    public static boolean connected(int p, int q) {
        return find(p) == find(q);
    }


    private static class Edge implements Comparable<Edge> {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }

        @Override
        public int compareTo(Edge that) {
            return this.w < that.w ? -1 : (this.w > that.w ? 1 : 0);
        }

    }
}
