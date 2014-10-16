package com.coderevisited.trees.binarytree;

public class BinaryTreeNode
{
    private final int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public int getValue()
    {
        return value;
    }

    public BinaryTreeNode getLeft()
    {
        return left;
    }

    public BinaryTreeNode getRight()
    {
        return right;
    }

    public void setLeft(BinaryTreeNode left)
    {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right)
    {
        this.right = right;
    }
}
