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
 */

package com.coderevisited.linkedlists.singly;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * User    : Suresh
 * Date    : 12/07/16
 * Version : v1
 */
public class PrintFirstLast {

    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        SinglyLinkedList.printList(head, pw);

        printFistLast(head);

        SinglyLinkedList.printList(head, pw);
        pw.close();
    }

    private static void printFistLast(SinglyLinkedListNode head) {

        SinglyLinkedListNode current = head;
        while (current != null) {
            SinglyLinkedListNode last = current;
            SinglyLinkedListNode prev = null;
            while (last.getNext() != null) {
                prev = last;
                last = last.getNext();
            }

            if (prev != null) {
                prev.setNext(null);
                SinglyLinkedListNode temp = current.getNext();
                current.setNext(last);
                last.setNext(temp);
                current = current.getNext().getNext();
            } else {
                current = current.getNext();
            }

        }
    }
}
