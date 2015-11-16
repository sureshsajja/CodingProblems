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

import java.io.PrintWriter;

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

    public static DoublyLinkedListNode buildDLLWithArbitraryPointers()
    {

        DoublyLinkedListNode five = new DoublyLinkedListNode(5, null, null);
        DoublyLinkedListNode four = new DoublyLinkedListNode(4, null, five);
        DoublyLinkedListNode three = new DoublyLinkedListNode(3, null, four);
        DoublyLinkedListNode two = new DoublyLinkedListNode(2, null, three);
        DoublyLinkedListNode one = new DoublyLinkedListNode(1, null, two);

        one.setPrev(three);
        two.setPrev(one);
        three.setPrev(five);
        four.setPrev(three);
        five.setPrev(two);

        return one;
    }

    public static void printList(DoublyLinkedListNode head, PrintWriter pw)
    {
        while (head != null) {
            pw.print(head.getValue());
            head = head.getNext();
            if (head != null) {
                pw.print("->");
            }
        }
        pw.println();
    }
}
