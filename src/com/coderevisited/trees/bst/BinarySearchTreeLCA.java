package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class BinarySearchTreeLCA
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        System.out.println("LCA(1,8) : " + findLCA(1, 8, root));
    }

    private static int findLCA(int n1, int n2, BinaryTreeNode node)
    {
        BinaryTreeNode lca = findLCAUtil(n1, n2, node);
        if (find(n1, lca) && find(n2, lca))
            return lca.getValue();
        return -1;
    }

    public static boolean find(int n, BinaryTreeNode node)
    {
        if (node == null)
            return false;
        if (node.getValue() == n)
            return true;
        if (node.getValue() < n)
            return find(n, node.getRight());
        else
            return find(n, node.getLeft());
    }

    private static BinaryTreeNode findLCAUtil(int n1, int n2, BinaryTreeNode root)
    {
        if (root == null)
            return null;
        if (root.getValue() > n1 && root.getValue() > n2) {
            return findLCAUtil(n1, n2, root.getLeft());
        }

        if (root.getValue() < n1 && root.getValue() < n2) {
            return findLCAUtil(n1, n2, root.getRight());
        }
        return root;
    }
}
