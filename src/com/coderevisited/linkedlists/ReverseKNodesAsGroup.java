package com.coderevisited.linkedlists;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseKNodesAsGroup
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
        ReverseKNodesAsGroup list = new ReverseKNodesAsGroup();
        list.buildList();
        list.printList(pw);

        pw.println("Reversing K nodes by iterative call");
        list.reverseKNodes(5);
        list.printList(pw);

        pw.println("Reversing K nodes by recursive call");
        list.reverseKNodesRecursive(5);
        list.printList(pw);

        pw.close();
    }

    public void reverseKNodesRecursive(int k)
    {
        head = reverseKNodesRecursiveUtil(head, k);
    }


    public Node reverseKNodesRecursiveUtil(Node n, int k)
    {
        Node current = n;
        Node next = null;
        Node prev = null;
        int count = k;

        //Reverse K nodes
        while (current != null && count > 0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count--;
        }

        //Now next points to K+1 th node, returns the pointer to the head node
        if (next != null) {
            n.next = reverseKNodesRecursiveUtil(next, k);
        }
        //return head node
        return prev;
    }


    public void reverseKNodes(int k)
    {
        //Start with head
        Node current = head;
        //last node after reverse
        Node prevTail = null;
        //first node before reverse
        Node prevCurrent = head;
        while (current != null) {

            //loop for reversing K nodes
            int count = k;
            Node tail = null;
            while (current != null && count > 0) {
                Node next = current.next;
                current.next = tail;
                tail = current;
                current = next;
                count--;
            }
            //reversed K Nodes

            if (prevTail != null) {
                //Link this set and previous set
                prevTail.next = tail;
            } else {
                //We just reversed first set of K nodes, update head point to the Kth Node
                head = tail;
            }
            //save the last node after reverse since we need to connect to the next set.
            prevTail = prevCurrent;
            //Save the current node, which will become the last node after reverse
            prevCurrent = current;
        }
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
