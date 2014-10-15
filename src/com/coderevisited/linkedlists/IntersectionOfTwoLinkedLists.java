package com.coderevisited.linkedlists;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class IntersectionOfTwoLinkedLists
{
    public static void main(String[] args)
    {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode root1 = SinglyLinkedList.buildRandomList();
        SinglyLinkedListNode root2 = SinglyLinkedList.build123();
        connectLists(root1, root2);
        SinglyLinkedList.printList(root1, pw);
        SinglyLinkedList.printList(root2, pw);
        SinglyLinkedListNode intersection = findIntersectionOfTwoLists(root1, root2);
        pw.println("Intersection of two lists : " + intersection.getValue());
        pw.close();

    }

    private static SinglyLinkedListNode findIntersectionOfTwoLists(SinglyLinkedListNode root1, SinglyLinkedListNode root2)
    {
        int length1 = SinglyLinkedList.getLength(root1);
        int length2 = SinglyLinkedList.getLength(root2);

        if (length1 > length2) {
            int diff = length1 - length2;
            for (int i = 0; i < diff; i++) {
                root1 = root1.getNext();
            }
        } else {
            int diff = length2 - length1;
            for (int i = 0; i < diff; i++) {
                root2 = root2.getNext();
            }
        }

        while (root1 != null && root2 != null) {
            if (root1.getValue() == root2.getValue())
                return root1;
            root1 = root1.getNext();
            root2 = root2.getNext();
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
