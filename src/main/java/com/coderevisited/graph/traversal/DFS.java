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

package com.coderevisited.graph.traversal;

import com.coderevisited.graph.Graph;

import java.util.List;

/**
 * User    : Suresh
 * Date    : 11/07/16
 * Version : v1
 */
public class DFS {

    public static void main(String[] args) {
        Graph g = Graph.buildGraph();
        boolean[] visited = new boolean[g.getV()+1];
        dfs(g.getAdj(), visited, 1);
        System.out.println();
        visited = new boolean[g.getV() + 1];
        int[] length = new int[1];
        getLength(g.getAdj(), visited, 1, 2, length);
        System.out.println(length[0]);
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int vertex) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        List<Integer> list = adj.get(vertex);
        for (Integer i : list) {
            if (!visited[i]) {
                dfs(adj, visited, i);
            }
        }
    }


    private static boolean getLength(List<List<Integer>> adj, boolean[] visited, int vertex, int endVertex, int[] length)
    {
        if (vertex == endVertex) {
            return true;
        }
        visited[vertex] = true;
        List<Integer> list = adj.get(vertex);
        for (Integer i : list) {
            if (!visited[i]) {
                length[0]++;
                if (getLength(adj, visited, i, endVertex, length))
                    return true;
            }
        }
        return false;
    }
}
