package com.coderevisited.binarytree;

public class KDistantFromRoot
{

    private Node root;

    public static void main(String[] args)
    {
        KDistantFromRoot tree = new KDistantFromRoot();
        tree.buildTree();
        tree.printKDistantFromRoot(3);
    }

    private void printKDistantFromRoot(int k)
    {
        printKDistantFromRootUtil(root, k);
    }

    private void printKDistantFromRootUtil(Node node, int k)
    {
        if (node == null)
            return;

        if (k == 0) {
            System.out.print(node.value + " ");
            return;
        }

        printKDistantFromRootUtil(node.left, k - 1);
        printKDistantFromRootUtil(node.right, k - 1);

    }

    public void buildTree()
    {

        /**
         *               6
         *             /   \
         *           2     12
         *          / \      \
         *         11   4      19
         *            / \    /
         *           3  15  8
         */
        Node one = new Node(11, null, null);
        Node three = new Node(3, null, null);
        Node five = new Node(15, null, null);
        Node eight = new Node(8, null, null);
        Node four = new Node(4, three, five);
        Node two = new Node(2, one, four);
        Node nine = new Node(19, eight, null);
        Node seven = new Node(12, null, nine);
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
