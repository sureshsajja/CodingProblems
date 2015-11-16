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
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  29/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/problem/algorithm/3-types/
 */
public class ThreeTypes {

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
        int M = nextInt();

        int[] menCount = new int[]{N};

        int[] menParent = new int[N + 1];
        int[] menSize = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            menParent[i] = i;
            menSize[i] = 1;
        }

        int[] womenCount = new int[]{N};
        int[] womenParent = new int[N + 1];
        int[] womenSize = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            womenParent[i] = i;
            womenSize[i] = 1;
        }

        Map<Integer, List<Edge>> map = new HashMap<Integer, List<Edge>>();
        map.put(1, new ArrayList<Edge>());
        map.put(2, new ArrayList<Edge>());
        map.put(3, new ArrayList<Edge>());

        for (int i = 0; i < M; i++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            List<Edge> list = map.get(c);
            list.add(new Edge(a, b));
            map.put(c, list);
        }

        int notRequired = 0;
        List<Edge> list = map.get(3);
        for (Edge e : list) {
            if (!connected(e.v, e.u, menParent)) {
                union(e.v, e.u, menParent, menSize, menCount);
            }
            if (!connected(e.v, e.u, womenParent)) {
                union(e.v, e.u, womenParent, womenSize, womenCount);
            } else {
                notRequired++;
            }
        }

        list = map.get(2);
        for (Edge e : list) {
            if (!connected(e.v, e.u, womenParent)) {
                union(e.v, e.u, womenParent, womenSize, womenCount);

            } else {
                notRequired++;
            }
        }


        list = map.get(1);
        for (Edge e : list) {
            if (!connected(e.v, e.u, menParent)) {
                union(e.v, e.u, menParent, menSize, menCount);

            } else {
                notRequired++;
            }
        }

        if (womenCount[0] != 1 || menCount[0] != 1) {
            pw.println(-1);
        } else {
            pw.println(notRequired);
        }

        reader.close();
        pw.close();
    }

    public static int find(int p, int[] parent) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }

    public static void union(int p, int q, int[] parent, int[] size, int[] count) {
        int rootP = find(p, parent);
        int rootQ = find(q, parent);
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }
        count[0]--;
    }

    public static boolean connected(int p, int q, int[] parent) {
        return find(p, parent) == find(q, parent);
    }

    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }
}