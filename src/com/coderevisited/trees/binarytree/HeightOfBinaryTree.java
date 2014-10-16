package com.coderevisited.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfBinaryTree
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildSkewedTree();
        int height = findHeight(root);
        System.out.println("Height of the tree by Iterative method : " + height);
        height = findHeightRecursive(root);
        System.out.println("Height of the tree by Recursive method : " + height);
    }

    private static int findHeightRecursive(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        int hl = findHeightRecursive(root.getLeft());
        int hr = findHeightRecursive(root.getRight());
        if (hl > hr)
            return 1 + hl;
        else
            return 1 + hr;
    }

    private static int findHeight(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        Queue<Integer> heightQueue = new LinkedList<>();
        bfsQueue.add(root);
        int height = 1;
        heightQueue.add(1);
        while (!bfsQueue.isEmpty()) {
            BinaryTreeNode node = bfsQueue.poll();
            height = heightQueue.poll();
            if (node.getLeft() != null) {
                bfsQueue.add(node.getLeft());
                heightQueue.add(height + 1);
            }
            if (node.getRight() != null) {
                bfsQueue.add(node.getRight());
                heightQueue.add(height + 1);
            }
        }
        return height;
    }
}
