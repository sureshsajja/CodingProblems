package com.coderevisited.binarytree;

public class KDistantFromANode
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printKDistantNodes(root, 4, 3);
    }

    public static int printKDistantNodes(BinaryTreeNode node, int target, int k)
    {
        if (node == null)
            return -1;

        if (node.getValue() == target) {
            KDistantFromRoot.printKDistantFromRoot(node, k);
            return 0;
        }
        //distance of target node from left child
        int left = printKDistantNodes(node.getLeft(), target, k);
        if (left >= 0) {

            if (left + 1 == k)
                System.out.print(node.getValue() + " ");
            else
                KDistantFromRoot.printKDistantFromRoot(node.getRight(), k - left - 2);

            //It is 1+left distant from node
            return 1 + left;

        }
        //distance of target node from right child
        int right = printKDistantNodes(node.getRight(), target, k);
        if (right >= 0) {

            if (right + 1 == k)
                System.out.print(node.getValue() + " ");
            else
                KDistantFromRoot.printKDistantFromRoot(node.getLeft(), k - right - 2);

            //It is 1+right distant from node
            return 1 + right;

        }

        return -1;
    }
}
