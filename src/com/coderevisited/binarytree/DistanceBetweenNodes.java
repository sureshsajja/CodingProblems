package com.coderevisited.binarytree;

public class DistanceBetweenNodes
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        System.out.println("distance between nodes 2, 9 : " + findDistance(2, 9, root));
        System.out.println("distance between nodes 11, 5 : " + findDistance(11, 5, root));
        System.out.println("distance between nodes 3, 7 : " + findDistance(3, 7, root));
        System.out.println("distance between nodes 19, 4 : " + findDistance(19, 4, root));
        System.out.println("distance between nodes 1, 20 : " + findDistance(1, 20, root));
    }

    private static int findDistance(int n1, int n2, BinaryTreeNode root)
    {
        BinaryTreeNode lca = findLCA(n1, n2, root);
        int distance = findDistanceUtil(n1, lca, 0);
        int distance2 = findDistanceUtil(n2, lca, 0);
        if (distance > 0 && distance2 > 0)
            return distance + distance2;
        else {
            return -1;
        }

    }

    private static int findDistanceUtil(int k, BinaryTreeNode lca, int distance)
    {
        if (lca == null)
            return -1;

        if (lca.getValue() == k)
            return distance;

        int i = findDistanceUtil(k, lca.getLeft(), distance + 1);
        if (i != -1)
            return i;

        return findDistanceUtil(k, lca.getRight(), distance + 1);
    }


    public static BinaryTreeNode findLCA(int n1, int n2, BinaryTreeNode node)
    {

        if (node == null) {
            return null;
        }

        //If we find n1 or n2.. this is the LCA
        if (node.getValue() == n1 || node.getValue() == n2) {
            return node;
        }

        //find if n1 or n2 are in the left sub tree
        BinaryTreeNode left = findLCA(n1, n2, node.getLeft());
        //find if n1 or n2 are in the right sub tree
        BinaryTreeNode right = findLCA(n1, n2, node.getRight());

        if (left != null && right != null) {
            //one node is in the left sub tree and another node is in the right sub tree
            return node;
        }

        //return node which is not -1
        if (left != null)
            return left;

        else return right;
    }
}
