package com.coderevisited.bst;

public class BinarySearchTreeLCA
{

    private Node root;

    public static void main(String[] args)
    {
        BinarySearchTreeLCA lca = new BinarySearchTreeLCA();
        lca.buildBST();
        System.out.println("LCA(1,13) : " + lca.findLCA(1, 13, lca.getRoot()));
    }

    public Node getRoot()
    {
        return root;

    }

    private int findLCA(int n1, int n2, Node node)
    {
        Node lca = findLCAUtil(n1, n2, node);
        if (find(n1, lca) && find(n2, lca))
            return lca.value;
        return -1;
    }

    public boolean find(int n, Node node)
    {
        if (node == null)
            return false;
        if (node.value == n)
            return true;
        if (node.value < n)
            return find(n, node.right);
        else
            return find(n, node.left);
    }

    private Node findLCAUtil(int n1, int n2, Node node)
    {
        if (node == null)
            return null;
        if (node.value > n1 && node.value > n2) {
            return findLCAUtil(n1, n2, node.left);
        }

        if (node.value < n1 && node.value < n2) {
            return findLCAUtil(n1, n2, node.right);
        }
        return node;
    }

    public void buildBST()
    {

        /**
         *               8
         *             /   \
         *           3      10
         *          / \      \
         *         1   6      14
         *            / \    /
         *           4   7  13
         */
        Node one = new Node(1, null, null);
        Node four = new Node(4, null, null);
        Node seven = new Node(7, null, null);
        Node thirteen = new Node(13, null, null);
        Node six = new Node(6, four, seven);
        Node fourteen = new Node(14, thirteen, null);
        Node three = new Node(3, one, six);
        Node ten = new Node(10, null, fourteen);
        root = new Node(8, three, ten);

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
