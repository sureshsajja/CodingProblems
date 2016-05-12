package com.coderevisited.trees;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.out;

/**
 * ssajja 01-04-2016
 */
public class ViableTree {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        Node root = new Node(false, null, null);
        int V = nextInt();
        for (int v = 0; v < V; v++) {
            String line = next();
            Node current = root;
            for (char c : line.toCharArray()) {
                if (c == 'L') {

                    if (current.left == null) {
                        current.left = new Node(false, null, null);
                    }
                    current = current.left;
                } else if (c == 'R') {
                    if (current.right == null) {
                        current.right = new Node(false, null, null);
                    }
                    current = current.right;
                }
            }
            current.exists = true;
        }

        int[] visited = new int[] {0};
        printPreOrder(root, visited);
        if (visited[0] != V) {
            pw.println(0);
        } else {
            pw.println(1);
        }

        pw.close();
        reader.close();

    }

    private static void printPreOrder(Node node, int[] visited) {
        if (node == null || !node.exists) {
            return;
        }
        visited[0]++;
        printPreOrder(node.left, visited);
        printPreOrder(node.right, visited);

    }

    private static class Node {
        private boolean exists;
        private Node left;
        private Node right;

        public Node(boolean exists, Node left, Node right) {
            this.exists = exists;
            this.left = left;
            this.right = right;
        }
    }
}
