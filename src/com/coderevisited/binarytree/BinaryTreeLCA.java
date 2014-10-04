package com.coderevisited.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLCA
{

    private Node root;

    public static void main(String[] args)
    {
        BinaryTreeLCA lca = new BinaryTreeLCA();

        lca.buildTree();
        System.out.println("LCA(5,11) : " + lca.findLCA(5, 11));
        System.out.println("LCA(1,9) : " + lca.findLCA(1, 9));
        System.out.println("LCA(3,8) : " + lca.findLCA(3, 8));


        System.out.println("LCA(5,11) : " + lca.findLCASingleTraversal(5, 11));
        System.out.println("LCA(1,9) : " + lca.findLCASingleTraversal(1, 9));
        System.out.println("LCA(3,8) : " + lca.findLCASingleTraversal(3, 8));

    }

    private int findLCASingleTraversal(int n1, int n2)
    {
        boolean[] found = new boolean[2];
        Node lca = findLCASingleTraversalUtil(n1, n2, root, found);
        //verify if both nodes are present
        if (found[0] && found[1] || found[1] && find(n1, lca) || found[0] && find(n2, lca)) {
            return lca.value;
        } else {
            return -1;
        }
    }

    private boolean find(int n, Node node)
    {
        return node != null && (node.value == n || find(n, node.left) || find(n, node.right));
    }


    public Node findLCASingleTraversalUtil(int n1, int n2, Node node, boolean[] found)
    {

        if (node == null) {
            return null;
        }

        //If we find n1 or n2.. this is the LCA
        if (node.value == n1) {
            found[0] = true;
            return node;

        }

        if (node.value == n2) {
            found[1] = true;
            return node;
        }


        //find if n1 or n2 are in the left sub tree
        Node left = findLCASingleTraversalUtil(n1, n2, node.left, found);
        //find if n1 or n2 are in the right sub tree
        Node right = findLCASingleTraversalUtil(n1, n2, node.right, found);

        if (left != null && right != null) {
            //one node is in the left sub tree and another node is in the right sub tree
            return node;
        }

        //return node which is not -1
        if (left != null)
            return left;

        else return right;

    }

    public int findLCA(int n1, int n2)
    {
        List<Node> path1 = new LinkedList<>();
        List<Node> path2 = new LinkedList<>();
        int lca = -1;
        if (searchForPath(n1, path1, root)) {
            if (searchForPath(n2, path2, root)) {
                //If we find path of two nodes, return the last common node
                for (int i = 0; i < path1.size() && i < path2.size(); i++) {
                    if (path1.get(i).value != path2.get(i).value) {
                        lca = path1.get(i - 1).value;
                        break;
                    }
                }
            }
        }
        return lca;
    }

    public boolean searchForPath(int n, List<Node> path, Node node)
    {
        if (node == null) {
            return false;
        }

        //Include in the path
        path.add(node);

        if (node.value == n) {
            //If this is the current node, return true
            return true;
        }

        //Recursively search left sub tree and right sub tree
        if ((node.left != null && searchForPath(n, path, node.left)) || (node.right != null && searchForPath(n, path, node.right))) {
            return true;
        }

        //Present node is not included in the path. Remove it
        path.remove(node);
        return false;
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
