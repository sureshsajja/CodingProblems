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

import java.io.PrintWriter;

public class SinglyLinkedList
{
    public static SinglyLinkedListNode build123()
    {
        SinglyLinkedListNode three = new SinglyLinkedListNode(3, null);
        SinglyLinkedListNode two = new SinglyLinkedListNode(2, three);
        return new SinglyLinkedListNode(1, two);
    }

    public static SinglyLinkedListNode buildSortedLinkedList()
    {
        SinglyLinkedListNode nine = new SinglyLinkedListNode(9, null);
        SinglyLinkedListNode eight = new SinglyLinkedListNode(8, nine);
        SinglyLinkedListNode seven = new SinglyLinkedListNode(7, eight);
        SinglyLinkedListNode six = new SinglyLinkedListNode(6, seven);
        SinglyLinkedListNode five = new SinglyLinkedListNode(5, six);
        SinglyLinkedListNode four = new SinglyLinkedListNode(4, five);
        SinglyLinkedListNode three = new SinglyLinkedListNode(3, four);
        SinglyLinkedListNode two = new SinglyLinkedListNode(2, three);
        return new SinglyLinkedListNode(1, two);
    }

    public static SinglyLinkedListNode buildRandomList()
    {
        SinglyLinkedListNode a = new SinglyLinkedListNode(12, null);
        SinglyLinkedListNode b = new SinglyLinkedListNode(8, a);
        SinglyLinkedListNode c = new SinglyLinkedListNode(6, b);
        SinglyLinkedListNode d = new SinglyLinkedListNode(14, c);
        SinglyLinkedListNode e = new SinglyLinkedListNode(7, d);
        SinglyLinkedListNode f = new SinglyLinkedListNode(9, e);
        SinglyLinkedListNode g = new SinglyLinkedListNode(4, f);
        SinglyLinkedListNode h = new SinglyLinkedListNode(0, g);
        return new SinglyLinkedListNode(11, h);
    }


    public static SinglyLinkedListNode buildLoopedLinkedList()
    {
        SinglyLinkedListNode a = new SinglyLinkedListNode(12, null);
        SinglyLinkedListNode b = new SinglyLinkedListNode(8, a);
        SinglyLinkedListNode c = new SinglyLinkedListNode(6, b);
        SinglyLinkedListNode d = new SinglyLinkedListNode(14, c);
        SinglyLinkedListNode e = new SinglyLinkedListNode(7, d);
        SinglyLinkedListNode f = new SinglyLinkedListNode(9, e);
        SinglyLinkedListNode g = new SinglyLinkedListNode(4, f);
        SinglyLinkedListNode h = new SinglyLinkedListNode(0, g);
        a.setNext(e);
        return new SinglyLinkedListNode(11, h);
    }

    public static SinglyLinkedListNode buildListWithDuplicates() {

        SinglyLinkedListNode a = new SinglyLinkedListNode(12, null);
        SinglyLinkedListNode b = new SinglyLinkedListNode(8, a);
        SinglyLinkedListNode c = new SinglyLinkedListNode(6, b);
        SinglyLinkedListNode d = new SinglyLinkedListNode(14, c);
        SinglyLinkedListNode e = new SinglyLinkedListNode(7, d);
        SinglyLinkedListNode f = new SinglyLinkedListNode(8, e);
        SinglyLinkedListNode g = new SinglyLinkedListNode(6, f);
        SinglyLinkedListNode h = new SinglyLinkedListNode(0, g);
        return new SinglyLinkedListNode(11, h);

    }

    public static int getLength(SinglyLinkedListNode head)
    {
        int count = 0;
        while (head != null) {
            count++;
            head = head.getNext();
        }
        return count;
    }

    public static void printList(SinglyLinkedListNode head, PrintWriter pw)
    {
        while (head != null) {
            pw.print(head.getValue());
            head = head.getNext();
            if (head != null)
                pw.print("->");
        }
        pw.println();
    }

    public static SinglyLinkedListNode searchForItem(SinglyLinkedListNode head, int item)
    {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            if (temp.getValue() == item) {
                return temp;
            }
            temp = temp.getNext();
        }
        return null;
    }
}
