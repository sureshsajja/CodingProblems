package com.coderevisited.linkedlists;

public class DoublyLinkedList
{

    public static DoublyLinkedListNode buildSortedLinkedList()
    {
        DoublyLinkedListNode nine = new DoublyLinkedListNode(9, null, null);
        DoublyLinkedListNode eight = new DoublyLinkedListNode(8, null, nine);
        DoublyLinkedListNode seven = new DoublyLinkedListNode(7, null, eight);
        DoublyLinkedListNode six = new DoublyLinkedListNode(6, null, seven);
        DoublyLinkedListNode five = new DoublyLinkedListNode(5, null, six);
        DoublyLinkedListNode four = new DoublyLinkedListNode(4, null, five);
        DoublyLinkedListNode three = new DoublyLinkedListNode(3, null, four);
        DoublyLinkedListNode two = new DoublyLinkedListNode(2, null, three);
        DoublyLinkedListNode one = new DoublyLinkedListNode(1, null, two);

        nine.setPrev(eight);
        eight.setPrev(seven);
        seven.setPrev(six);
        six.setPrev(five);
        five.setPrev(four);
        four.setPrev(three);
        three.setPrev(two);
        two.setPrev(one);

        return one;
    }

    public static int getLength(DoublyLinkedListNode head)
    {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }
}
