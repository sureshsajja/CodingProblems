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

package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class ReverseALinkedList
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing by recursive call");
        SinglyLinkedListNode[] reverseHead = new SinglyLinkedListNode[1];
        reverseRecursive(head, reverseHead);
        head = reverseHead[0];
        SinglyLinkedList.printList(head, pw);

        pw.println("Reversing by iterative call");
        head = reverseList(head);
        SinglyLinkedList.printList(head, pw);

        pw.close();
    }

    public static void reverseRecursive(SinglyLinkedListNode current, SinglyLinkedListNode[] head)
    {
        if (current == null) {
            return;
        }

        //base case
        SinglyLinkedListNode next = current.getNext();
        if (next == null) {
            head[0] = current;
            return;
        }

        reverseRecursive(next, head);

        //Make next node points to current node
        next.setNext(current);
        //Remove existing link
        current.setNext(null);
    }

    public static SinglyLinkedListNode reverseList(SinglyLinkedListNode head)
    {
        //initially Current is head
        SinglyLinkedListNode current = head;
        //initially previous is null
        SinglyLinkedListNode prev = null;
        while (current != null) {
            //Save the next node
            SinglyLinkedListNode next = current.getNext();
            //Make current node points to the previous
            current.setNext(prev);
            //update previous
            prev = current;
            //update current
            current = next;
        }
        return prev;
    }

}
