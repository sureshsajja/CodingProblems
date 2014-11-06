package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseAlternateAndAppendLast
{
    public static void main(String[] args)
    {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        reverserAlternateAndAppendLast(head);
        SinglyLinkedList.printList(head, pw);
        pw.close();

    }

    private static void reverserAlternateAndAppendLast(SinglyLinkedListNode head)
    {

        //Split the list
        SinglyLinkedListNode[] split = SplitLinkedListEvenOdd.splitList(head);
        //reverse the second list
        split[1] = ReverseALinkedList.reverseList(split[1]);
        head = split[0];
        while (head.getNext() != null) {
            head = head.getNext();
        }
        //append the second list to last
        head.setNext(split[1]);
    }
}
