package com.coderevisited.trees.binarytree;

public class LevelOfANode
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        System.out.println("Level of Node 4 is : " + findLevel(root, 4, 0));
        System.out.println("Level of Node 16 is : " + findLevel(root, 16, 0));
    }

    private static int findLevel(BinaryTreeNode root, int k, int level)
    {
        if (root == null)
            return 0;

        if (root.getValue() == k)
            return level;

        int ll = findLevel(root.getLeft(), k, level + 1);
        if (ll > 0)
            return ll;

        return findLevel(root.getRight(), k, level + 1);
    }
}
