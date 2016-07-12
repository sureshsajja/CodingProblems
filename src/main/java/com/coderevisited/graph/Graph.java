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
 */

package com.coderevisited.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * User    : Suresh
 * Date    : 11/07/16
 * Version : v1
 */
public class Graph {

    private final int V;
    private final int E;
    private final List<List<Integer>> adj;

    @SuppressWarnings("unchecked")
    public Graph(int V, int E) {
        this.V = V;
        this.E = E;
        this.adj = new ArrayList<>();
        for (int v = 0; v <= V; v++) {
            adj.add(new ArrayList<Integer>());
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public List<List<Integer>> getAdj() {
        return adj;
    }

    private void addEdge(int p, int q) {
        adj.get(p).add(q);
        adj.get(q).add(p);
    }

    public static Graph buildGraph() {
        Graph g = new Graph(6, 8);
        g.addEdge(1, 6);
        g.addEdge(3, 5);
        g.addEdge(3, 4);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.addEdge(4, 5);
        g.addEdge(4, 6);
        g.addEdge(1, 3);
        return g;
    }
}
