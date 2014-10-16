package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class KthNodeFromLast
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);
        SinglyLinkedListNode node = findKthNodeFromLast(head, 5);
        if (node != null)
            pw.println("5th Node from last :" + node.getValue());
        else
            pw.println("Node not found");
        pw.close();
    }

    private static SinglyLinkedListNode findKthNodeFromLast(SinglyLinkedListNode head, int k)
    {
        SinglyLinkedListNode ptr1 = null;
        SinglyLinkedListNode ptr2 = head;

        int currPos = 0;
        while (ptr2 != null) {
            // increment ptr2 up to k positions
            currPos++;
            ptr2 = ptr2.getNext();

            if (currPos == k)
                ptr1 = head; // start ptr1 from head
            else if (currPos > k) {
                assert ptr1 != null;
                ptr1 = ptr1.getNext();
            }
        }

        if (ptr1 != null)
            return ptr1;
        else
            return null;
    }
}
