package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class SuccessorAndPredecessorBST
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        BinaryTreeNode[] nodes = new BinaryTreeNode[2];
        findInOrderSucAndPre(root, 7, nodes);
        if (nodes[0] != null) {
            System.out.println("Successor of 7 : " + nodes[0].getValue());
        } else {
            System.out.println("No Successor for 7 ");
        }

        if (nodes[1] != null) {
            System.out.println("Predecessor of 7 : " + nodes[1].getValue());
        } else {
            System.out.println("No Predecessor for 7 ");
        }
    }

    private static void findInOrderSucAndPre(BinaryTreeNode root, int k, BinaryTreeNode[] nodes)
    {
        if (root == null)
            return;
        if (root.getValue() == k) {
            if (root.getRight() != null) {
                BinaryTreeNode temp = root.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                nodes[0] = temp;
            }

            if (root.getLeft() != null) {
                BinaryTreeNode temp = root.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                nodes[1] = temp;
            }

            return;
        }
        if (root.getValue() > k) {
            nodes[0] = root;
            findInOrderSucAndPre(root.getLeft(), k, nodes);
        } else {
            nodes[1] = root;
            findInOrderSucAndPre(root.getRight(), k, nodes);
        }
    }
}
