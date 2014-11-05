package com.coderevisited.linkedlists.doubly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class CopyDLLWithNextAndArbitrary
{

    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        DoublyLinkedListNode head = DoublyLinkedList.buildDLLWithArbitraryPointers();
        DoublyLinkedListNode newHead = copyList(head);
        DoublyLinkedList.printList(newHead, pw);
        pw.close();

    }

    private static DoublyLinkedListNode copyList(DoublyLinkedListNode head)
    {
        // Map<Integer, DoublyLinkedListNode> prev = new HashMap<>();
        DoublyLinkedListNode newHead = null;
        if (head != null) {
            newHead = new DoublyLinkedListNode(head.getValue(), null, null);
            //  prev.put(head.getPrev().getValue(), null);
            head = head.getNext();
        }

        DoublyLinkedListNode temp = newHead;
        while (head != null) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(head.getValue(), null, null);
            temp.setNext(node);
            temp = node;
            //  prev.put(head.getPrev().getValue(), null);
            head = head.getNext();

        }


        return newHead;
    }

}
