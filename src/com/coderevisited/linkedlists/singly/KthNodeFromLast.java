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

public class KthNodeFromLast
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);
        SinglyLinkedListNode node = findKthNodeFromLast(head, 5);
        if (node != null)
            pw.println("5th Node from last :" + node.getValue());
        else
            pw.println("Node not found");

        node = findKthNodeFromLastRecursive(head, 5, new int[1]);
        if (node != null)
            pw.println("5th Node from last :" + node.getValue());
        else
            pw.println("Node not found");


        pw.close();
    }

    private static SinglyLinkedListNode findKthNodeFromLast(SinglyLinkedListNode head, int k)
    {
        SinglyLinkedListNode ptr1 = null;
        SinglyLinkedListNode ptr2 = head;

        int currPos = 0;
        while (ptr2 != null) {
            // increment ptr2 up to k positions
            currPos++;
            ptr2 = ptr2.getNext();

            if (currPos == k)
                ptr1 = head; // start ptr1 from head
            else if (currPos > k) {
                assert ptr1 != null;
                ptr1 = ptr1.getNext();
            }
        }

        if (ptr1 != null)
            return ptr1;
        else
            return null;
    }

    private static SinglyLinkedListNode findKthNodeFromLastRecursive(SinglyLinkedListNode head, int k, int[] i) {

        if (head == null) {
            return null;
        }

        SinglyLinkedListNode node = findKthNodeFromLastRecursive(head.getNext(), k, i);
        i[0] = i[0] + 1;
        if (i[0] == k) {
            return head;
        }
        return node;
    }
}
