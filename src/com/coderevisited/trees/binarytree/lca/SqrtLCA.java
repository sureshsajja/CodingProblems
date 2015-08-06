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

package com.coderevisited.trees.binarytree.lca;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
 */
public class SqrtLCA
{

    private Node root;

    public SqrtLCA(Node root)
    {
        this.root = root;
        int height = bfs();
        int sqrtHeight = (int) Math.sqrt(height);
        preProcess(root, sqrtHeight);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int V = scanner.nextInt();
        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>();

        for (int i = 0; i < V - 1; i++) {
            int x = scanner.nextInt();
            if (!nodeMap.containsKey(x)) {
                nodeMap.put(x, new Node(x));
            }
            int y = scanner.nextInt();
            if (!nodeMap.containsKey(y)) {
                nodeMap.put(y, new Node(y));
            }

            Node m = nodeMap.get(x);
            Node n = nodeMap.get(y);
            m.addChild(n);
            n.addChild(m);
        }

        SqrtLCA lca = new SqrtLCA(nodeMap.get(1));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            pw.println(lca.findLCA(nodeMap.get(A), nodeMap.get(B)).getV());
        }

        scanner.close();
        pw.close();
    }

    private Node findLCA(Node A, Node B)
    {
        while (A.getSuperParent().getV() != B.getSuperParent().getV()) {
            if (A.getLevel() > B.getLevel()) {
                A = A.getSuperParent();
            } else {
                B = B.getSuperParent();
            }
        }

        while (A.getV() != B.getV()) {
            if (A.getLevel() > B.getLevel()) {
                A = A.getParent();
            } else {
                B = B.getParent();
            }

        }
        return A;
    }

    private void preProcess(Node node, int blockSize)
    {

        if (node.getLevel() < blockSize) {
            node.addSuperParent(root);
        } else {
            if (node.getLevel() % blockSize == 0) {
                node.addSuperParent(node.getParent());
            } else {
                node.addSuperParent(node.getParent().getSuperParent());
            }
        }

        for (Node child : node.getChildren()) {
            preProcess(child, blockSize);
        }
    }

    private int bfs()
    {
        int level = 0;
        Queue<Node> bfsQueue = new LinkedList<Node>();
        bfsQueue.add(root);
        root.addLevel(level);
        int height = 0;
        while (!bfsQueue.isEmpty()) {
            Node n = bfsQueue.poll();
            for (Node child : n.getChildren()) {
                child.removeChild(n);
                child.addParent(n);
                child.addLevel(n.getLevel() + 1);
                bfsQueue.add(child);
            }
            height = n.getLevel() + 1;
        }
        return height;
    }

    private static class Node
    {
        private final int v;
        private final List<Node> children;
        private Node parent;
        private int level;
        private Node superParent;

        private Node(int v)
        {
            this.v = v;
            this.children = new LinkedList<Node>();
        }

        public List<Node> getChildren()
        {
            return children;
        }

        public void addChild(Node node)
        {
            children.add(node);
        }

        public void removeChild(Node node)
        {
            children.remove(node);
        }

        public void addParent(Node node)
        {
            this.parent = node;
        }

        public void addLevel(int n)
        {
            this.level = n;
        }

        public int getLevel()
        {
            return level;
        }

        public Node getParent()
        {
            return parent;
        }

        public void addSuperParent(Node node)
        {
            this.superParent = node;
        }

        public Node getSuperParent()
        {
            return superParent;
        }

        public int getV()
        {
            return v;
        }
    }

}
