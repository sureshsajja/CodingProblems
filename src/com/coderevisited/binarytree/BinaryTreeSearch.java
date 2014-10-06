package com.coderevisited.binarytree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeSearch
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        List<BinaryTreeNode> path = new LinkedList<>();
        if (searchForPath(5, path, root)) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).getValue());
                if (i <= path.size() - 2)
                    System.out.print("->");
            }
        } else {
            System.out.println("Key nt found");
        }

    }

    public static boolean ifExists(int n, BinaryTreeNode node)
    {
        return node != null && (node.getValue() == n || ifExists(n, node.getLeft()) || ifExists(n, node.getRight()));
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
