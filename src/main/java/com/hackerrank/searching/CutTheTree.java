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

package com.hackerrank.searching;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class CutTheTree
{

    private Map<Integer, Node> nodeMap;
    private int totalWeight;

    public CutTheTree(Scanner scanner)
    {
        int V = scanner.nextInt();
        nodeMap = new HashMap<Integer, Node>();
        totalWeight = 0;
        for (int v = 1; v <= V; v++) {
            int weight = scanner.nextInt();
            totalWeight += weight;
            nodeMap.put(v, new Node(v, weight));
        }
        for (int i = 0; i < V - 1; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            Node n = nodeMap.get(x);
            Node m = nodeMap.get(y);
            n.addChild(m);
            m.addChild(n);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        CutTheTree tree = new CutTheTree(scanner);
        pw.println(tree.getDiff());
        scanner.close();
        pw.close();
    }

    private int getDiff()
    {

        dfs(nodeMap.get(1));
        int[] visit = new int[nodeMap.size() + 1];
        int minDiff = Integer.MAX_VALUE;
        Queue<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(nodeMap.get(1));
        while (!bfsQueue.isEmpty()) {
            Node n = bfsQueue.poll();
            visit[n.getV()] = 1;
            for (Node child : n.getChildren()) {
                if (visit[child.getV()] == 0) {
                    int diff = Math.abs(2 * child.getCumWeight() - totalWeight);
                    minDiff = minDiff < diff ? minDiff : diff;
                    bfsQueue.add(child);
                }
            }
        }
        return minDiff;
    }


    private int dfs(Node node)
    {
        int cumWeight = 0;
        node.setVisited();
        for (Node child : node.getChildren()) {
            if (!child.isVisited()) {
                cumWeight += dfs(child);
            }
        }
        node.updateCumWeight(cumWeight);
        return node.getCumWeight();
    }

    private class Node
    {
        private final int v;
        private final List<Node> children;
        private int cumWeight;
        private boolean visited;

        public Node(int v, int weight)
        {
            this.v = v;
            children = new LinkedList<Node>();
            cumWeight = weight;
        }

        public List<Node> getChildren()
        {
            return children;
        }

        public void addChild(Node node)
        {
            children.add(node);
        }

        public int getCumWeight()
        {
            return cumWeight;
        }

        public void updateCumWeight(int weight)
        {
            cumWeight += weight;
        }

        public void setVisited()
        {
            visited = true;
        }

        public boolean isVisited()
        {
            return visited;
        }

        public int getV()
        {
            return v;
        }
    }
}
