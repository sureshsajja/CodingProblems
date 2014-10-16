package com.coderevisited.trees.binarytree;

public class KDistantFromLeaf
{
    private static final int MAX_HEIGHT = 10;

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printKDistantFromLeaf(root, new int[MAX_HEIGHT], new boolean[MAX_HEIGHT], 4, 0);
    }


    private static void printKDistantFromLeaf(BinaryTreeNode node, int[] path, boolean[] visited, int k, int len)
    {
        if (node == null)
            return;

        path[len] = node.getValue();
        visited[len] = false;

        if (node.getLeft() == null && node.getRight() == null && len - k >= 0 && !visited[len - k]) {
            System.out.print(path[len - k] + " ");
            visited[len - k] = true;
        }

        printKDistantFromLeaf(node.getLeft(), path, visited, k, len + 1);
        printKDistantFromLeaf(node.getRight(), path, visited, k, len + 1);

    }
}
