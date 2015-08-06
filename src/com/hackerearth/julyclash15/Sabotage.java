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

package com.hackerearth.julyclash15;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  18/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/july-clash-15/algorithm/sabotage-1/
 */
public class Sabotage {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] parent;
    private static int[] size;


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
        int M = nextInt();


        parent = new int[N + 1];
        size = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        boolean[] edge = new boolean[M + 1];
        Edge[] edges = new Edge[M + 1];
        for (int m = 1; m <= M; m++) {
            int u = nextInt();
            int v = nextInt();
            Edge e = new Edge(u, v);
            edges[m] = e;
        }

        int count = 0;
        boolean[] visited = new boolean[N + 1];


        for (int i = M; i > 0; i--) {
            if (!visited[edges[i].v] || !visited[edges[i].u]) {
                visited[edges[i].v] = true;
                visited[edges[i].u] = true;
                edge[i] = true;
                count++;
                union(edges[i].v, edges[i].u);
            } else if (!connected(edges[i].v, edges[i].u)) {
                edge[i] = true;
                count++;
                union(edges[i].v, edges[i].u);
            }
        }

        pw.println(edge.length - 1 - count);
        for (int e = 1; e < edge.length; e++) {
            if (!edge[e]) {
                pw.println(e);
            }
        }

        reader.close();
        pw.close();
    }

    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;

        }
    }

    public static void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

    }

    public static int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public static boolean connected(int p, int q) {
        return find(p) == find(q);
    }

}
