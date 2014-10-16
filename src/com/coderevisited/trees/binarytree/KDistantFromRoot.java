package com.coderevisited.trees.binarytree;

public class KDistantFromRoot
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printKDistantFromRoot(root, 3);
    }

    public static void printKDistantFromRoot(BinaryTreeNode node, int k)
    {
        if (node == null)
            return;

        if (k == 0) {
            System.out.print(node.getValue() + " ");
            return;
        }

        printKDistantFromRoot(node.getLeft(), k - 1);
        printKDistantFromRoot(node.getRight(), k - 1);

    }
}
