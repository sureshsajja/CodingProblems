package com.coderevisited.binarytree;

public class IsBST
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildFalseBST();
        boolean bst = IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (bst) {
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }

        root = BinaryTree.buildBST();
        bst = IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (bst) {
            System.out.println("Tree is BST");
        } else {
            System.out.println("Tree is not BST");
        }


    }

    private static boolean checkIfBST(BinaryTreeNode root, int min, int max)
    {
        return root == null || min <= root.getValue() && root.getValue() <= max && checkIfBST(root.getLeft(), min, root.getValue()) && checkIfBST(root.getRight(), root.getValue(), max);
    }

}
