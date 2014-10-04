package com.coderevisited.binarytree;

public class KDistantFromANode
{

    private Node root;

    public static void main(String[] args)
    {
        KDistantFromANode tree = new KDistantFromANode();
        tree.buildTree();
        tree.printKDistantNodes(4, 3);
    }

    private void printKDistantNodes(int target, int k)
    {
        printKDistantNodesUtil(root, target, k);
    }

    private int printKDistantNodesUtil(Node node, int target, int k)
    {
        if (node == null)
            return -1;

        if (node.value == target) {
            printKDistantFromRoot(node, k);
            return 0;
        }
        //distance of target node from left child
        int left = printKDistantNodesUtil(node.left, target, k);
        if (left >= 0) {

            if (left + 1 == k)
                System.out.print(node.value + " ");
            else
                printKDistantFromRoot(node.right, k - left - 2);

            //It is 1+left distant from node
            return 1 + left;

        }
        //distance of target node from right child
        int right = printKDistantNodesUtil(node.right, target, k);
        if (right >= 0) {

            if (right + 1 == k)
                System.out.print(node.value + " ");
            else
                printKDistantFromRoot(node.left, k - right - 2);

            //It is 1+right distant from node
            return 1 + right;

        }

        return -1;
    }

    private void printKDistantFromRoot(Node node, int k)
    {
        if (node == null)
            return;

        if (k == 0) {
            System.out.print(node.value + " ");
            return;
        }

        printKDistantFromRoot(node.left, k - 1);
        printKDistantFromRoot(node.right, k - 1);

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
