package com.coderevisited.trees.binarytree;

public class BinaryTree
{

    public static BinaryTreeNode buildFalseBST()
    {
        /**
         *               3
         *             /   \
         *           2      5
         *          / \
         *         1   4
         *
         *
         */
        BinaryTreeNode one = new BinaryTreeNode(1, null, null);
        BinaryTreeNode four = new BinaryTreeNode(4, null, null);
        BinaryTreeNode two = new BinaryTreeNode(2, one, four);
        BinaryTreeNode five = new BinaryTreeNode(3, null, null);
        return new BinaryTreeNode(3, two, five);
    }

    public static BinaryTreeNode buildBST()
    {

        /**
         *               6
         *             /   \
         *           2      7
         *          / \      \
         *         1   4      9
         *            / \    /
         *           3   5  8
         */
        BinaryTreeNode one = new BinaryTreeNode(1, null, null);
        BinaryTreeNode three = new BinaryTreeNode(3, null, null);
        BinaryTreeNode five = new BinaryTreeNode(5, null, null);
        BinaryTreeNode eight = new BinaryTreeNode(8, null, null);
        BinaryTreeNode four = new BinaryTreeNode(4, three, five);
        BinaryTreeNode two = new BinaryTreeNode(2, one, four);
        BinaryTreeNode nine = new BinaryTreeNode(9, eight, null);
        BinaryTreeNode seven = new BinaryTreeNode(7, null, nine);
        return new BinaryTreeNode(6, two, seven);
    }

    public static BinaryTreeNode buildTree()
    {

        /**
         *               6
         *             /   \
         *           2      7
         *          / \      \
         *         11   4      19
         *            / \    /
         *           3   5  8
         */
        BinaryTreeNode eleven = new BinaryTreeNode(11, null, null);
        BinaryTreeNode three = new BinaryTreeNode(3, null, null);
        BinaryTreeNode five = new BinaryTreeNode(5, null, null);
        BinaryTreeNode eight = new BinaryTreeNode(8, null, null);
        BinaryTreeNode four = new BinaryTreeNode(4, three, five);
        BinaryTreeNode two = new BinaryTreeNode(2, eleven, four);
        BinaryTreeNode nineteen = new BinaryTreeNode(19, eight, null);
        BinaryTreeNode seven = new BinaryTreeNode(7, null, nineteen);
        return new BinaryTreeNode(6, two, seven);
    }

    public static BinaryTreeNode buildSkewedTree()
    {

        /**
         *                6
         *             /     \
         *           2       10
         *          / \    /    \
         *         1   3  7     12
         *              \  \   /  \
         *               4  8 11  13
         *                \  \    \
         *                 5  9   14
         *                         \
         *                         15
         */

        BinaryTreeNode one = new BinaryTreeNode(1, null, null);
        BinaryTreeNode five = new BinaryTreeNode(5, null, null);
        BinaryTreeNode nine = new BinaryTreeNode(9, null, null);
        BinaryTreeNode eleven = new BinaryTreeNode(11, null, null);
        BinaryTreeNode fifteen = new BinaryTreeNode(15, null, null);
        BinaryTreeNode four = new BinaryTreeNode(4, null, five);
        BinaryTreeNode three = new BinaryTreeNode(3, null, four);
        BinaryTreeNode two = new BinaryTreeNode(2, one, three);
        BinaryTreeNode eight = new BinaryTreeNode(8, null, nine);
        BinaryTreeNode seven = new BinaryTreeNode(7, null, eight);
        BinaryTreeNode fourteen = new BinaryTreeNode(14, null, fifteen);
        BinaryTreeNode thirteen = new BinaryTreeNode(13, null, fourteen);
        BinaryTreeNode twelve = new BinaryTreeNode(12, eleven, thirteen);
        BinaryTreeNode ten = new BinaryTreeNode(10, seven, twelve);
        return new BinaryTreeNode(6, two, ten);

    }
}
