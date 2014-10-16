package com.coderevisited.linkedlists.doubly;

public class DoublyLinkedListNode
{
    private int value;
    private DoublyLinkedListNode next;
    private DoublyLinkedListNode prev;

    public DoublyLinkedListNode(int value, DoublyLinkedListNode prev, DoublyLinkedListNode next)
    {
        this.value = value;
        this.prev = prev;
        this.next = next;
    }

    public DoublyLinkedListNode getNext()
    {
        return next;
    }

    public int getValue()
    {
        return value;
    }

    public DoublyLinkedListNode getPrev()
    {
        return prev;
    }

    public void setPrev(DoublyLinkedListNode prev)
    {
        this.prev = prev;
    }

    public void setNext(DoublyLinkedListNode next)
    {
        this.next = next;
    }
}
