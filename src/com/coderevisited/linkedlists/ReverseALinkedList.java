package com.coderevisited.linkedlists;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseALinkedList
{
    private Node head;

    public void buildList()
    {
        Node nine = new Node(9, null);
        Node eight = new Node(8, nine);
        Node seven = new Node(7, eight);
        Node six = new Node(6, seven);
        Node five = new Node(5, six);
        Node four = new Node(4, five);
        Node three = new Node(3, four);
        Node two = new Node(2, three);
        head = new Node(1, two);
    }

    public void printList(PrintWriter pw)
    {
        Node temp = head;
        while (temp != null) {
            pw.print(temp.val);
            temp = temp.next;
            if (temp != null)
                pw.print("->");
        }
        pw.println();
    }

    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        ReverseALinkedList list = new ReverseALinkedList();
        list.buildList();
        list.printList(pw);

        pw.println("Reversing by recursive call");
        list.reverseRecursive();
        list.printList(pw);

        pw.println("Reversing by iterative call");
        list.reverseList();
        list.printList(pw);

        pw.close();
    }

    public void reverseRecursive()
    {
        reverseRecursiveUtil(head);
    }

    public void reverseRecursiveUtil(Node current)
    {
        if (current == null) {
            return;
        }

        //base case
        Node next = current.next;
        if (next == null) {
            head = current;
            return;
        }

        reverseRecursiveUtil(next);

        //Make next node points to current node
        next.next = current;
        //Remove existing link
        current.next = null;
    }

    public void reverseList()
    {
        //initially Current is head
        Node current = head;
        //initially previous is null
        Node prev = null;
        while (current != null) {
            //Save the next node
            Node next = current.next;
            //Make current node points to the previous
            current.next = prev;
            //update previous
            prev = current;
            //update current
            current = next;
        }
        head = prev;
    }


    private static class Node
    {
        private int val;
        private Node next;

        public Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }
    }

}
