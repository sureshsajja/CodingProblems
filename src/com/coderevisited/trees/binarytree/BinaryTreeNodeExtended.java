package com.coderevisited.trees.binarytree;


public class BinaryTreeNodeExtended
{
    private final int value;
    private BinaryTreeNodeExtended nextRight;
    private BinaryTreeNodeExtended left;
    private BinaryTreeNodeExtended right;

    public BinaryTreeNodeExtended(int value, BinaryTreeNodeExtended left, BinaryTreeNodeExtended right)
    {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public BinaryTreeNodeExtended getLeft()
    {
        return left;
    }

    public void setLeft(BinaryTreeNodeExtended left)
    {
        this.left = left;
    }

    public BinaryTreeNodeExtended getRight()
    {
        return right;
    }

    public void setRight(BinaryTreeNodeExtended right)
    {
        this.right = right;
    }

    public int getValue()
    {
        return value;
    }

    public BinaryTreeNodeExtended getNextRight()
    {
        return nextRight;
    }

    public void setNextRight(BinaryTreeNodeExtended nextRight)
    {
        this.nextRight = nextRight;
    }
}
