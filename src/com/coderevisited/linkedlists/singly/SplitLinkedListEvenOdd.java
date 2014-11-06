package com.coderevisited.linkedlists.singly;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SplitLinkedListEvenOdd
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedListNode[] split = splitList(head);
        if (split[0] != null) {
            SinglyLinkedList.printList(split[0], pw);
        }
        if (split[1] != null) {
            SinglyLinkedList.printList(split[1], pw);
        }

        pw.close();
    }

    public static SinglyLinkedListNode[] splitList(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode headAlternate;
        if (head.getNext() != null) {
            headAlternate = head.getNext();
        } else {
            //we have one node only
            return new SinglyLinkedListNode[]{head, null};
        }

        SinglyLinkedListNode tempHead = head;
        SinglyLinkedListNode tempAltHead = headAlternate;
        while (tempAltHead != null) {
            tempHead.setNext(tempHead.getNext().getNext());
            tempHead = tempHead.getNext();
            tempAltHead.setNext(tempAltHead.getNext().getNext());
            tempAltHead = tempAltHead.getNext();
        }

        return new SinglyLinkedListNode[]{head, headAlternate};
    }
}
