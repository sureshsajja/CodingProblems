package com.coderevisited.linkedlists;


public class ReverseALinkedList
{

    private Node head;

    public ReverseALinkedList()
    {

        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        Node five = new Node(5, null);
        Node six = new Node(6, null);
        Node seven = new Node(7, null);
        Node eight = new Node(8, null);
        Node nine = new Node(9, null);

        head = one;
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(eight);
        eight.setNext(nine);
    }


    public static void main(String[] args)
    {

        ReverseALinkedList list = new ReverseALinkedList();
        list.printList();
        list.reverseList();
        list.printList();
        list.reverseKNodes(2);
        list.printList();

    }

    private void reverseKNodes(int k)
    {
        Node current = head;
        Node prevHead = null;
        Node prevCurrent = null;
        while (current != null) {
            int count = k;
            Node prev = null;
            while (current != null && count > 0) {
                Node next = current.getNext();
                current.setNext(prev);
                prev = current;
                current = next;
                count--;
            }
            if (prevHead != null) {
                prevHead.setNext(prev);
                prevHead = prevCurrent;
                prevCurrent = current;
            } else {
                prevHead = head;
                head = prev;
                prevCurrent = current;
            }

        }
    }


    private void reverseList()
    {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
    }

    private void printList()
    {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.getVal() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    private static class Node
    {
        private final int val;
        private Node next;

        public Node(int val, Node next)
        {
            this.val = val;
            this.next = next;
        }

        public int getVal()
        {
            return val;
        }

        public Node getNext()
        {
            return next;
        }

        public void setNext(Node next)
        {
            this.next = next;
        }
    }

}
