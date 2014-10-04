package com.coderevisited.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal
{
    private Node root;

    public Node getRoot()
    {
        return root;
    }

    public static void main(String[] args)
    {
        BinaryTreeTraversal tree = new BinaryTreeTraversal();
        tree.buildTree();
        System.out.println("Pre-order traversal:");
        tree.printPreOrder(tree.getRoot());
        System.out.println();
        System.out.println("In-order traversal:");
        tree.printInOrder(tree.getRoot());
        System.out.println();
        System.out.println("Post-order traversal:");
        tree.printPostOder(tree.getRoot());
        System.out.println();
        System.out.println("level-order traversal:");
        tree.printLevelOrder(tree.getRoot());

    }

    /**
     * root -> left sub tree -> right sub tree
     */
    public void printPreOrder(Node node)
    {
        if (node == null)
            return;
        System.out.print(node.value + " ");
        if (node.left != null)
            printPreOrder(node.left);
        if (node.right != null)
            printPreOrder(node.right);

    }

    /**
     * left sub tree -> root --> right sub tree
     */
    public void printInOrder(Node node)
    {
        if (node == null)
            return;
        if (node.left != null)
            printInOrder(node.left);
        System.out.print(node.value + " ");
        if (node.right != null)
            printInOrder(node.right);
    }

    /**
     * Left sub tree -> right sub tree -> root
     */
    public void printPostOder(Node node)
    {
        if (node == null)
            return;
        if (node.left != null)
            printPostOder(node.left);
        if (node.right != null)
            printPostOder(node.right);
        System.out.print(node.value + " ");

    }

    public void printLevelOrder(Node node)
    {
        Queue<Node> bfsQueue = new LinkedList<>();
        if (node != null)
            bfsQueue.add(node);
        while (!bfsQueue.isEmpty()) {
            Node n = bfsQueue.poll();
            System.out.print(n.value + " ");
            if (n.left != null)
                bfsQueue.add(n.left);
            if (n.right != null)
                bfsQueue.add(n.right);
        }
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
