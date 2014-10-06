package com.coderevisited.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeTraversal
{
    public static void main(String[] args)
    {

        BinaryTreeNode root = BinaryTree.buildTree();
        System.out.println("Pre-order traversal:");
        printPreOrder(root);
        System.out.println();
        System.out.println("In-order traversal:");
        printInOrder(root);
        System.out.println();
        System.out.println("Post-order traversal:");
        printPostOder(root);
        System.out.println();
        System.out.println("level-order traversal:");
        printLevelOrder(root);

    }

    /**
     * root -> left sub tree -> right sub tree
     */
    public static void printPreOrder(BinaryTreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());

    }

    /**
     * left sub tree -> root --> right sub tree
     */
    public static void printInOrder(BinaryTreeNode node)
    {
        if (node == null)
            return;
        printInOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    /**
     * Left sub tree -> right sub tree -> root
     */
    public static void printPostOder(BinaryTreeNode node)
    {
        if (node == null)
            return;
        printPostOder(node.getLeft());
        printPostOder(node.getRight());
        System.out.print(node.getValue() + " ");

    }

    public static void printLevelOrder(BinaryTreeNode node)
    {
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        if (node != null)
            bfsQueue.add(node);
        while (!bfsQueue.isEmpty()) {
            BinaryTreeNode n = bfsQueue.poll();
            System.out.print(n.getValue() + " ");
            if (n.getLeft() != null)
                bfsQueue.add(n.getLeft());
            if (n.getRight() != null)
                bfsQueue.add(n.getRight());
        }
    }
}
