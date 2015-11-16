/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.coderevisited.linkedlists.doubly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class CopyDLLWithNextAndArbitrary
{

    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        DoublyLinkedListNode head = DoublyLinkedList.buildDLLWithArbitraryPointers();
        DoublyLinkedListNode newHead = copyListWithoutExtraSpace(head);
        DoublyLinkedList.printList(newHead, pw);
        pw.close();

    }

    private static DoublyLinkedListNode copyList(DoublyLinkedListNode head)
    {
        //Save key -> newly created Node
        Map<Integer, DoublyLinkedListNode> prev = new HashMap<>();
        //Save given list head
        DoublyLinkedListNode origHead = head;
        //start building the new list with next pointers, at each step save the newly created node
        DoublyLinkedListNode newHead = null;
        if (head != null) {
            newHead = new DoublyLinkedListNode(head.getValue(), null, null);
            prev.put(newHead.getValue(), newHead);
            head = head.getNext();
        }

        DoublyLinkedListNode temp = newHead;
        while (head != null) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(head.getValue(), null, null);
            prev.put(node.getValue(), node);
            temp.setNext(node);
            temp = node;
            head = head.getNext();
        }

        //Now traverse the original list, get the key of prev node and look in the map for corresponding new Node
        //update previous
        temp = newHead;
        while (origHead != null) {
            DoublyLinkedListNode prevNode = prev.get(origHead.getPrev().getValue());
            temp.setPrev(prevNode);
            origHead = origHead.getNext();
            temp = temp.getNext();
        }
        return newHead;
    }


    private static DoublyLinkedListNode copyListWithoutExtraSpace(DoublyLinkedListNode head)
    {
        DoublyLinkedListNode temp = head;
        //1. Insert a duplicate node next to each node in the original list
        while (temp != null) {
            DoublyLinkedListNode node = new DoublyLinkedListNode(temp.getValue(), null, temp.getNext());
            temp.setNext(node);
            temp = node.getNext();
        }

        temp = head;
        //2. set the previous pointer to all created nodes
        while (temp != null) {
            temp.getNext().setPrev(temp.getPrev().getNext());
            temp = temp.getNext().getNext();
        }

        //3. restore next pointers
        DoublyLinkedListNode newHead = head.getNext();
        temp = head;
        DoublyLinkedListNode copy = newHead;
        while (temp != null) {
            temp.setNext(temp.getNext().getNext());
            if (copy.getNext() == null) {
                copy.setNext(null);
            } else {
                copy.setNext(copy.getNext().getNext());
                copy = copy.getNext();
            }
            temp = temp.getNext();
        }


        return newHead;

    }

}
