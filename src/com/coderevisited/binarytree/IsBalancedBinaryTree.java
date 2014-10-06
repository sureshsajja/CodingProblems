package com.coderevisited.binarytree;

public class IsBalancedBinaryTree
{
    public static void main(String[] args)
    {

        Node root = buildTree();
        if (isHeightBalanced(root, new int[]{0})) {
            System.out.println("Tree is balanced");
        } else {
            System.out.println("Tree is not balanced");
        }

    }

    private static boolean isHeightBalanced(Node root, int[] height)
    {

        if (root == null)
            return true;

        //array of size 1 to store height of left sub tree and right sub tree
        int[] hr = new int[]{0};
        int[] hl = new int[]{0};


        boolean l = isHeightBalanced(root.left, hl);
        boolean r = isHeightBalanced(root.right, hr);

        height[0] = (hr[0] > hl[0] ? hr[0] : hl[0]) + 1;

        return Math.abs(hr[0] - hl[0]) <= 1 && l && r;
    }

    public static Node buildTree()
    {

        /**
         *               6
         *             /   \
         *           2      7
         *          / \    /  \
         *         11   4 10  19
         *            / \    /
         *           3   5  8
         */
        Node one = new Node(11, null, null);
        Node three = new Node(3, null, null);
        Node five = new Node(5, null, null);
        Node eight = new Node(8, null, null);
        Node four = new Node(4, three, five);
        Node two = new Node(2, one, four);
        Node nine = new Node(19, eight, null);
        Node ten = new Node(10, null, null);
        Node seven = new Node(7, ten, nine);
        return new Node(6, two, seven);

    }

    private static class Node
    {
        private int value;
        private Node left;
        private Node right;

        public Node(int value, Node left, Node right)
        {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }
}
