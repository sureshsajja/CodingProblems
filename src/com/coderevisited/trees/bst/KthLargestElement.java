package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class KthLargestElement
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        for (int i = 1; i < 10; i++) {
            BinaryTreeNode kthSmallest = findKthLargestElement(root, new int[]{i});
            System.out.println(i + "th Largest " + kthSmallest.getValue());
        }
    }

    private static BinaryTreeNode findKthLargestElement(BinaryTreeNode node, int[] k)
    {
        if (node == null)
            return null;
        BinaryTreeNode result = findKthLargestElement(node.getRight(), k);
        if (result != null)
            return result;
        k[0]--;
        if (k[0] == 0)
            return node;

        return findKthLargestElement(node.getLeft(), k);

    }
}
