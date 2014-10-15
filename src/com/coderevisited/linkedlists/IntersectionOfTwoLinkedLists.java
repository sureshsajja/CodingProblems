package com.coderevisited.linkedlists;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IntersectionOfTwoLinkedLists
{
    public static void main(String[] args)
    {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head1 = SinglyLinkedList.buildRandomList();
        SinglyLinkedListNode head2 = SinglyLinkedList.build123();
        connectLists(head1, head2);
        SinglyLinkedList.printList(head1, pw);
        SinglyLinkedList.printList(head2, pw);
        SinglyLinkedListNode intersection = findIntersectionOfTwoLists(head1, head2);
        pw.println("Intersection of two lists : " + intersection.getValue());
        pw.close();

    }

    private static SinglyLinkedListNode findIntersectionOfTwoLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        int length1 = SinglyLinkedList.getLength(head1);
        int length2 = SinglyLinkedList.getLength(head2);

        if (length1 > length2) {
            int diff = length1 - length2;
            for (int i = 0; i < diff; i++) {
                head1 = head1.getNext();
            }
        } else {
            int diff = length2 - length1;
            for (int i = 0; i < diff; i++) {
                head2 = head2.getNext();
            }
        }

        while (head1 != null && head2 != null) {
            if (head1.getValue() == head2.getValue())
                return head1;
            head1 = head1.getNext();
            head2 = head2.getNext();
        }
        return null;
    }

    private static void connectLists(SinglyLinkedListNode root1, SinglyLinkedListNode root2)
    {
        SinglyLinkedListNode toAppend = SinglyLinkedList.searchForItem(root1, 4);

        //last node of second list is connected to node with value 4.
        SinglyLinkedListNode temp = root2;
        while (temp.getNext() != null)
            temp = temp.getNext();

        temp.setNext(toAppend);

        //list 1: 11->0->4->9->7->14->6->8->12
        //               |
        //list 2: 1->2->3


    }
}
