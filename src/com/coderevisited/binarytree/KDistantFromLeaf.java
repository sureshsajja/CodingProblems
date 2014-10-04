package com.coderevisited.binarytree;

public class KDistantFromLeaf
{
    private Node root;
    private static final int MAX_HEIGHT = 10;

    public static void main(String[] args)
    {
        KDistantFromLeaf tree = new KDistantFromLeaf();
        tree.buildTree();
        tree.printKDistantFromLeaf();
    }

    private void printKDistantFromLeaf()
    {
        printKDistantFromLeafUtil(root, new int[MAX_HEIGHT], new boolean[MAX_HEIGHT], 4, 0);

    }

    private void printKDistantFromLeafUtil(Node node, int[] path, boolean[] visited, int k, int len)
    {
        if (node == null)
            return;

        path[len] = node.value;
        visited[len] = false;

        if (node.left == null && node.right == null && len - k >= 0 && !visited[len - k]) {
            System.out.print(path[len - k] + " ");
            visited[len - k] = true;
        }

        printKDistantFromLeafUtil(node.left, path, visited, k, len + 1);
        printKDistantFromLeafUtil(node.right, path, visited, k, len + 1);

    }

    public void buildTree()
    {

        /**
         *               6
         *             /   \
         *           2      7
         *          / \      \
         *         11   4      19
         *            / \    /
         *           3   5  8
         */
        Node one = new Node(11, null, null);
        Node three = new Node(3, null, null);
        Node five = new Node(5, null, null);
        Node eight = new Node(8, null, null);
        Node four = new Node(4, three, five);
        Node two = new Node(2, one, four);
        Node nine = new Node(19, eight, null);
        Node seven = new Node(7, null, nine);
        root = new Node(6, two, seven);

    }

    private static class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
