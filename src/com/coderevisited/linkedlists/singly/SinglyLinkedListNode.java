package com.coderevisited.linkedlists.singly;

public class SinglyLinkedListNode
{

    private int value;
    private SinglyLinkedListNode next;

    public SinglyLinkedListNode(int value, SinglyLinkedListNode next)
    {
        this.value = value;
        this.next = next;
    }

    public SinglyLinkedListNode getNext()
    {
        return next;
    }

    public int getValue()
    {
        return value;
    }

    public void setNext(SinglyLinkedListNode next)
    {
        this.next = next;
    }
}
