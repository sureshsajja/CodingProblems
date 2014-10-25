package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class KthSmallestElement
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        for (int i = 1; i < 10; i++) {
            BinaryTreeNode kthSmallest = findKthSmallestElement(root, new int[]{i});
            System.out.println(i + "th Smallest " + kthSmallest.getValue());
        }
    }

    private static BinaryTreeNode findKthSmallestElement(BinaryTreeNode node, int[] k)
    {
        if (node == null)
            return null;
        BinaryTreeNode result = findKthSmallestElement(node.getLeft(), k);
        if (result != null)
            return result;
        k[0]--;
        if (k[0] == 0)
            return node;

        return findKthSmallestElement(node.getRight(), k);

    }
}
