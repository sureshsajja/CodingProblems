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

package com.hackerearth.Capillary;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

//TODO not tested
public class IOI2050
{

    private List<Edge>[] adj;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            pw.print("Case: ");
            pw.print(t + 1);
            pw.println();
            //number of vertices
            int N = scanner.nextInt();
            //number of edges
            int P = scanner.nextInt();
            int M = scanner.nextInt();
            PriorityQueue<Edge> minPQ = new PriorityQueue<Edge>();
            for (int p = 0; p < P; p++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                Edge e = new Edge(v, u, w);
                minPQ.add(e);
            }
            IOI2050 mst = new IOI2050(minPQ, N);

            for (int m = 0; m < M; m++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                pw.println(mst.findCost(v, u));
            }
        }


        scanner.close();
        pw.close();
    }

    private int findCost(int v, int u)
    {
        Queue<Integer> bfsQueue = new LinkedList<Integer>();
        Queue<Integer> weightQueue = new LinkedList<Integer>();
        bfsQueue.add(v);
        weightQueue.add(0);

        int weight = 0;

        while (!bfsQueue.isEmpty()) {

            int index = bfsQueue.remove();
            weight = weightQueue.remove();
            if (index == u)
                return weight;
            for (Edge e : adj[index - 1]) {
                bfsQueue.add(e.other(index));
                weightQueue.add(weight + e.weight());
            }

        }
        return 0;
    }


    @SuppressWarnings("unchecked")
    private IOI2050(PriorityQueue<Edge> pq, int V)
    {

        UF uf = new UF(V);
        Queue<Edge> mst = new LinkedList<Edge>();
        while (!pq.isEmpty() && mst.size() < V - 1) {
            Edge e = pq.poll();
            int v = e.either();
            int u = e.other(v);
            if (!uf.connected(v - 1, u - 1)) {
                uf.union(v - 1, u - 1);
                mst.add(e);
            }
        }
        adj = (List<Edge>[]) new LinkedList[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new LinkedList<Edge>();
        }
        for (Edge e : mst) {
            int v = e.either();
            int u = e.other(v);
            adj[v - 1].add(e);
            adj[u - 1].add(e);
        }
    }

    private class UF
    {
        private int[] id;
        private byte[] rank;

        public UF(int N)
        {
            id = new int[N];
            rank = new byte[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                rank[i] = 0;
            }
        }

        public boolean connected(int p, int q)
        {
            return find(p) == find(q);
        }

        public int find(int p)
        {
            while (p != id[p]) {
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public void union(int p, int q)
        {
            int i = find(p);
            int j = find(q);
            if (i == j) return;
            if (rank[i] < rank[j]) id[i] = j;
            else if (rank[i] > rank[j]) id[j] = i;
            else {
                id[j] = i;
                rank[i]++;
            }
        }
    }

    private static class Edge implements Comparable<Edge>
    {
        private final int v;
        private final int u;
        private final int w;

        public Edge(int v, int u, int w)
        {
            this.v = v;
            this.u = u;
            this.w = w;
        }

        public int either()
        {
            return v;
        }

        public int other(int vertex)
        {
            if (vertex == v) return u;
            else return v;
        }

        public int weight()
        {
            return w;
        }

        @Override
        public int compareTo(Edge that)
        {
            if (this.weight() < that.weight()) return -1;
            else if (this.weight() > that.weight()) return 1;
            else return 0;
        }
    }
}





