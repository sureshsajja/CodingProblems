package com.coderevisited.binarytree;

import com.coderevisited.linkedlists.SinglyLinkedList;
import com.coderevisited.linkedlists.SinglyLinkedListNode;

public class SortedLLToBalancedBST
{
    public static void main(String[] args)
    {
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        int count = SinglyLinkedList.getLength(head);
        BinaryTreeNode root = buildBalancedBST(new SinglyLinkedListNode[]{head}, count);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }

        System.out.println();

        head = SinglyLinkedList.build123();
        count = SinglyLinkedList.getLength(head);
        root = buildBalancedBST(new SinglyLinkedListNode[]{head}, count);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }
    }

    private static BinaryTreeNode buildBalancedBST(SinglyLinkedListNode[] head, int count)
    {
        if (count <= 0)
            return null;

        BinaryTreeNode left = buildBalancedBST(head, count >> 1);
        BinaryTreeNode root = new BinaryTreeNode(head[0].getValue(), left, null);
        head[0] = head[0].getNext();
        root.setRight(buildBalancedBST(head, count - (count >> 1) - 1));
        return root;
    }
}
