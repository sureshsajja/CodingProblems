package com.coderevisited.binarytree;

public class IsBalancedBinaryTree
{
    public static void main(String[] args)
    {

        BinaryTreeNode root = BinaryTree.buildTree();
        if (isHeightBalanced(root, new int[]{0})) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }

    }

    private static boolean isHeightBalanced(BinaryTreeNode root, int[] height)
    {

        if (root == null)
            return true;

        //array of size 1 to store height of left sub tree and right sub tree
        int[] hr = new int[]{0};
        int[] hl = new int[]{0};


        boolean l = isHeightBalanced(root.getLeft(), hl);
        boolean r = isHeightBalanced(root.getRight(), hr);

        height[0] = (hr[0] > hl[0] ? hr[0] : hl[0]) + 1;

        return Math.abs(hr[0] - hl[0]) <= 1 && l && r;
    }

}
