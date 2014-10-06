package com.coderevisited.binarytree;


public class SortedArrayToBalancedBST
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTreeNode root = constructBalancedBST(array, 0, array.length - 1);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }
    }

    public static BinaryTreeNode constructBalancedBST(int[] array, int low, int high)
    {

        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        BinaryTreeNode root = new BinaryTreeNode(array[mid], null, null);

        root.setLeft(constructBalancedBST(array, low, mid - 1));
        root.setRight(constructBalancedBST(array, mid + 1, high));

        return root;
    }
}
