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

public class LoopInALinkedList
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        SinglyLinkedListNode head = SinglyLinkedList.buildLoopedLinkedList();
        boolean loopExists = findIfLoopExistsUsingFloyds(head);
        pw.println("Loops existed by floyds? : " + loopExists);
        loopExists = findIfLoopExistsUsingBrents(head);
        pw.println("Loops existed by brents? : " + loopExists);
        int length = findLengthOfTheLoop(head);
        pw.println("Length of the loop: " + length);
        SinglyLinkedListNode start = startNodeOfTheLoop(head);
        if (start != null)
        pw.println("Start node of the loop: " + start.getValue());

        pw.close();
    }

    private static int findLengthOfTheLoop(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode fastPtr = head;
        SinglyLinkedListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        int length = 0;
        if (loopExists) {
            do {
                slowPtr = slowPtr.getNext();
                length++;
            } while (slowPtr != fastPtr);
        }

        return length;
    }

    private static SinglyLinkedListNode startNodeOfTheLoop(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode fastPtr = head;
        SinglyLinkedListNode slowPtr = head;
        boolean loopExists = false;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr) {
                loopExists = true;
                break;
            }
        }
        if (loopExists) {
            slowPtr = head;
            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.getNext();
                fastPtr = fastPtr.getNext();
            }
            return fastPtr;
        } else
            return null;
    }

    private static boolean findIfLoopExistsUsingFloyds(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode fastPtr = head;
        SinglyLinkedListNode slowPtr = head;
        while (fastPtr != null && fastPtr.getNext() != null) {
            fastPtr = fastPtr.getNext().getNext();
            slowPtr = slowPtr.getNext();
            if (slowPtr == fastPtr)
                return true;

        }
        return false;
    }

    private static boolean findIfLoopExistsUsingBrents(SinglyLinkedListNode head)
    {
        SinglyLinkedListNode movingPtr = head;
        SinglyLinkedListNode stationaryPtr = head;
        int stepsTaken = 0;
        int stepLimit = 2;
        while (movingPtr != null) {
            movingPtr = movingPtr.getNext();
            stepsTaken++;
            if (movingPtr == stationaryPtr)
                return true;
            if (stepsTaken == stepLimit) {
                stepLimit = 2 * stepLimit;
                stepsTaken = 0;
                stationaryPtr = movingPtr;
            }
        }
        return false;
    }
}
