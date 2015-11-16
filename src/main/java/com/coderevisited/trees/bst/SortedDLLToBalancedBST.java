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

package com.coderevisited.trees.bst;

import com.coderevisited.linkedlists.doubly.DoublyLinkedList;
import com.coderevisited.linkedlists.doubly.DoublyLinkedListNode;

public class SortedDLLToBalancedBST
{
    public static void main(String[] args)
    {

        DoublyLinkedListNode head = DoublyLinkedList.buildSortedLinkedList();
        int count = DoublyLinkedList.getLength(head);
        DoublyLinkedListNode root = buildBalancedBST(new DoublyLinkedListNode[]{head}, count);
        printPreOrder(root);

    }

    private static DoublyLinkedListNode buildBalancedBST(DoublyLinkedListNode[] head, int count)
    {
        if (count <= 0)
            return null;

        DoublyLinkedListNode left = buildBalancedBST(head, count >> 1);
        DoublyLinkedListNode root = head[0];
        root.setPrev(left);
        head[0] = head[0].getNext();
        root.setNext(buildBalancedBST(head, count - (count >> 1) - 1));
        return root;
    }

    private static void printPreOrder(DoublyLinkedListNode node)
    {
        if (node == null)
            return;
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getPrev());
        printPreOrder(node.getNext());

    }
}
