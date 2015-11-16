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

public class SplitLinkedListEvenOdd
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedListNode[] split = splitList(head);
        if (split[0] != null) {
            SinglyLinkedList.printList(split[0], pw);
        }
        if (split[1] != null) {
            SinglyLinkedList.printList(split[1], pw);
        }

        pw.close();
    }

    public static SinglyLinkedListNode[] splitList(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode headAlternate;
        if (head.getNext() != null) {
            headAlternate = head.getNext();
        } else {
            //we have one node only
            return new SinglyLinkedListNode[]{head, null};
        }

        SinglyLinkedListNode tempHead = head;
        SinglyLinkedListNode tempAltHead = headAlternate;
        while (tempAltHead != null) {
            tempHead.setNext(tempHead.getNext().getNext());
            tempHead = tempHead.getNext();
            tempAltHead.setNext(tempAltHead.getNext().getNext());
            tempAltHead = tempAltHead.getNext();
        }

        return new SinglyLinkedListNode[]{head, headAlternate};
    }
}
