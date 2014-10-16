package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseKNodesAsGroup
{


    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing K nodes by iterative call");
        head = reverseKNodes(head, 5);
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing K nodes by recursive call");
        head = reverseKNodesRecursive(head, 5);
        SinglyLinkedList.printList(head, pw);

        pw.close();
    }


    public static SinglyLinkedListNode reverseKNodesRecursive(SinglyLinkedListNode head, int k)
    {
        SinglyLinkedListNode current = head;
        SinglyLinkedListNode next = null;
        SinglyLinkedListNode prev = null;
        int count = k;

        //Reverse K nodes
        while (current != null && count > 0) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
            count--;
        }

        //Now next points to K+1 th node, returns the pointer to the head node
        if (next != null) {
            head.setNext(reverseKNodesRecursive(next, k));
        }
        //return head node
        return prev;
    }


    public static SinglyLinkedListNode reverseKNodes(SinglyLinkedListNode head, int k)
    {
        //Start with head
        SinglyLinkedListNode current = head;
        //last node after reverse
        SinglyLinkedListNode prevTail = null;
        //first node before reverse
        SinglyLinkedListNode prevCurrent = head;
        while (current != null) {

            //loop for reversing K nodes
            int count = k;
            SinglyLinkedListNode tail = null;
            while (current != null && count > 0) {
                SinglyLinkedListNode next = current.getNext();
                current.setNext(tail);
                tail = current;
                current = next;
                count--;
            }
            //reversed K Nodes

            if (prevTail != null) {
                //Link this set and previous set
                prevTail.setNext(tail);
            } else {
                //We just reversed first set of K nodes, update head point to the Kth Node
                head = tail;
            }
            //save the last node after reverse since we need to connect to the next set.
            prevTail = prevCurrent;
            //Save the current node, which will become the last node after reverse
            prevCurrent = current;
        }

        return head;
    }
}
