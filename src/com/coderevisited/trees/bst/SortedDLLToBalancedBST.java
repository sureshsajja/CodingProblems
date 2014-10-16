package com.coderevisited.trees.bst;

import com.coderevisited.linkedlists.doubly.DoublyLinkedList;
import com.coderevisited.linkedlists.doubly.DoublyLinkedListNode;

public class SortedDLLToBalancedBST
{
    public static void main(String[] args)
    {

        DoublyLinkedListNode head = DoublyLinkedList.buildSortedLinkedList();
        int count = DoublyLinkedList.getLength(head);
        DoublyLinkedListNode root = buildBalancedBST(new DoublyLinkedListNode[]{head}, count);
        printPreOrder(root);

    }

    private static DoublyLinkedListNode buildBalancedBST(DoublyLinkedListNode[] head, int count)
    {
        if (count <= 0)
            return null;

        DoublyLinkedListNode left = buildBalancedBST(head, count >> 1);
        DoublyLinkedListNode root = head[0];
        root.setPrev(left);
        head[0] = head[0].getNext();
        root.setNext(buildBalancedBST(head, count - (count >> 1) - 1));
        return root;
    }

    private static void printPreOrder(DoublyLinkedListNode node)
    {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getPrev());
        printPreOrder(node.getNext());

    }
}
