package com.coderevisited.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLCA
{

    public static void main(String[] args)
    {

        BinaryTreeNode root = BinaryTree.buildTree();

        System.out.println("LCA(5,11) : " + findLCA(5, 11, root));
        System.out.println("LCA(1,9) : " + findLCA(1, 9, root));
        System.out.println("LCA(3,8) : " + findLCA(3, 8, root));


        System.out.println("LCA(5,11) : " + findLCASingleTraversal(5, 11, root));
        System.out.println("LCA(1,9) : " + findLCASingleTraversal(1, 9, root));
        System.out.println("LCA(3,8) : " + findLCASingleTraversal(3, 8, root));

    }

    private static int findLCASingleTraversal(int n1, int n2, BinaryTreeNode root)
    {
        boolean[] found = new boolean[2];
        BinaryTreeNode lca = findLCASingleTraversalUtil(n1, n2, root, found);
        //verify if both nodes are present
        if (found[0] && found[1] || found[1] && find(n1, lca) || found[0] && find(n2, lca)) {
            return lca.getValue();
        } else {
            return -1;
        }
    }

    private static boolean find(int n, BinaryTreeNode node)
    {
        return node != null && (node.getValue() == n || find(n, node.getLeft()) || find(n, node.getRight()));
    }


    public static BinaryTreeNode findLCASingleTraversalUtil(int n1, int n2, BinaryTreeNode node, boolean[] found)
    {

        if (node == null) {
            return null;
        }

        //If we find n1 or n2.. this is the LCA
        if (node.getValue() == n1) {
            found[0] = true;
            return node;

        }

        if (node.getValue() == n2) {
            found[1] = true;
            return node;
        }


        //find if n1 or n2 are in the left sub tree
        BinaryTreeNode left = findLCASingleTraversalUtil(n1, n2, node.getLeft(), found);
        //find if n1 or n2 are in the right sub tree
        BinaryTreeNode right = findLCASingleTraversalUtil(n1, n2, node.getRight(), found);

        if (left != null && right != null) {
            //one node is in the left sub tree and another node is in the right sub tree
            return node;
        }

        //return node which is not -1
        if (left != null)
            return left;

        else return right;

    }

    public static int findLCA(int n1, int n2, BinaryTreeNode root)
    {
        List<BinaryTreeNode> path1 = new LinkedList<>();
        List<BinaryTreeNode> path2 = new LinkedList<>();
        int lca = -1;
        if (searchForPath(n1, path1, root)) {
            if (searchForPath(n2, path2, root)) {
                //If we find path of two nodes, return the last common node
                for (int i = 0; i < path1.size() && i < path2.size(); i++) {
                    if (path1.get(i).getValue() != path2.get(i).getValue()) {
                        lca = path1.get(i - 1).getValue();
                        break;
                    }
                }
            }
        }
        return lca;
    }

    public static boolean searchForPath(int n, List<BinaryTreeNode> path, BinaryTreeNode node)
    {
        if (node == null) {
            return false;
        }

        //Include in the path
        path.add(node);

        if (node.getValue() == n) {
            //If this is the current node, return true
            return true;
        }

        //Recursively search left sub tree and right sub tree
        if (searchForPath(n, path, node.getLeft()) || searchForPath(n, path, node.getRight())) {
            return true;
        }

        //Present node is not included in the path. Remove it
        path.remove(node);
        return false;
    }
}
