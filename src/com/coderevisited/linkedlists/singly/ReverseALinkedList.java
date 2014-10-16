package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseALinkedList
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing by recursive call");
        SinglyLinkedListNode[] reverseHead = new SinglyLinkedListNode[1];
        reverseRecursive(head, reverseHead);
        head = reverseHead[0];
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing by iterative call");
        head = reverseList(head);
        SinglyLinkedList.printList(head, pw);

        pw.close();
    }

    public static void reverseRecursive(SinglyLinkedListNode current, SinglyLinkedListNode[] head)
    {
        if (current == null) {
            return;
        }

        //base case
        SinglyLinkedListNode next = current.getNext();
        if (next == null) {
            head[0] = current;
            return;
        }

        reverseRecursive(next, head);

        //Make next node points to current node
        next.setNext(current);
        //Remove existing link
        current.setNext(null);
    }

    public static SinglyLinkedListNode reverseList(SinglyLinkedListNode head)
    {
        //initially Current is head
        SinglyLinkedListNode current = head;
        //initially previous is null
        SinglyLinkedListNode prev = null;
        while (current != null) {
            //Save the next node
            SinglyLinkedListNode next = current.getNext();
            //Make current node points to the previous
            current.setNext(prev);
            //update previous
            prev = current;
            //update current
            current = next;
        }
        return prev;
    }

}
