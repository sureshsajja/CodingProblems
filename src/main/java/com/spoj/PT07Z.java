package com.spoj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * http://www.spoj.com/problems/PT07Z/
 *
 * @author sursajja
 */
public class PT07Z
{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;

    private static String next() throws IOException
    {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException
    {
        return parseInt(next());
    }


    public static void main(String[] args) throws IOException
    {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();
    }

    private static void solve() throws IOException
    {
        int V = nextInt();
        List<List<Integer>> adjacencyList = new ArrayList<>();

        for (int v = 0; v <= V; v++) {
            adjacencyList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < V - 1; i++) {
            int v = nextInt();
            int u = nextInt();
            adjacencyList.get(v).add(u);
            adjacencyList.get(u).add(v);
        }


        Pair pair = bfs(adjacencyList, V, 1);
        pair = bfs(adjacencyList, V, pair.deepVertex);
        pw.println(pair.maxDistance);

    }

    private static Pair bfs(List<List<Integer>> adjacencyList, int V, int start)
    {
        boolean[] visited = new boolean[V + 1];
        int[] distance = new int[V + 1];
        for (int i = 0; i < V + 1; i++) {
            distance[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        distance[start] = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            List<Integer> list = adjacencyList.get(top);
            for (Integer i : list) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    distance[i] = distance[top] + 1;
                }
            }
        }
        int maxDis = 0;
        int deepVertex = 0;

        for (int i = 0; i < V + 1; i++) {
            if (maxDis < distance[i]) {
                maxDis = distance[i];
                deepVertex = i;
            }
        }

        return new Pair(maxDis, deepVertex);
    }

    private static class Pair
    {
        int maxDistance;
        int deepVertex;

        Pair(int maxDistance, int deepVertex)
        {
            this.deepVertex = deepVertex;
            this.maxDistance = maxDistance;
        }
    }
}
