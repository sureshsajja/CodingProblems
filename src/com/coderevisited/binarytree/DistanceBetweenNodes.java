package com.coderevisited.binarytree;

public class DistanceBetweenNodes
{

    private Node root;

    public static void main(String[] args)
    {
        DistanceBetweenNodes tree = new DistanceBetweenNodes();
        tree.buildTree();
        System.out.println("distance between nodes 2, 9 : " + tree.findDistance(2, 9));
        System.out.println("distance between nodes 11, 5 : " + tree.findDistance(11, 5));
        System.out.println("distance between nodes 3, 7 : " + tree.findDistance(3, 7));
        System.out.println("distance between nodes 19, 4 : " + tree.findDistance(19, 4));
        System.out.println("distance between nodes 1, 20 : " + tree.findDistance(1, 20));
    }

    private int findDistance(int n1, int n2)
    {
        Node lca = findLCA(n1, n2, root);
        int distance = findDistanceUtil(n1, lca, 0);
        int distance2 = findDistanceUtil(n2, lca, 0);
        if (distance > 0 && distance2 > 0)
            return distance + distance2;
        else {
            return -1;
        }

    }

    private int findDistanceUtil(int k, Node lca, int distance)
    {
        if (lca == null)
            return -1;

        if (lca.value == k)
            return distance;

        int i = findDistanceUtil(k, lca.left, distance + 1);
        if (i != -1)
            return i;

        return findDistanceUtil(k, lca.right, distance + 1);
    }


    public Node findLCA(int n1, int n2, Node node)
    {

        if (node == null) {
            return null;
        }

        //If we find n1 or n2.. this is the LCA
        if (node.value == n1 || node.value == n2) {
            return node;
        }

        //find if n1 or n2 are in the left sub tree
        Node left = findLCA(n1, n2, node.left);
        //find if n1 or n2 are in the right sub tree
        Node right = findLCA(n1, n2, node.right);

        if (left != null && right != null) {
            //one node is in the left sub tree and another node is in the right sub tree
            return node;
        }

        //return node which is not -1
        if (left != null)
            return left;

        else return right;
    }

    public void buildTree()
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
        Node one = new Node(11, null, null);
        Node three = new Node(3, null, null);
        Node five = new Node(5, null, null);
        Node eight = new Node(8, null, null);
        Node four = new Node(4, three, five);
        Node two = new Node(2, one, four);
        Node nine = new Node(19, eight, null);
        Node seven = new Node(7, null, nine);
        root = new Node(6, two, seven);


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
