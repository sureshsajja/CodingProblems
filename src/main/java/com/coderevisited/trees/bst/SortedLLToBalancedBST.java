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

import com.coderevisited.linkedlists.singly.SinglyLinkedList;
import com.coderevisited.linkedlists.singly.SinglyLinkedListNode;
import com.coderevisited.trees.binarytree.BinaryTreeNode;
import com.coderevisited.trees.binarytree.BinaryTreeTraversal;
import com.coderevisited.trees.binarytree.IsBalancedBinaryTree;

public class SortedLLToBalancedBST
{
    public static void main(String[] args)
    {
        SinglyLinkedListNode head = SinglyLinkedList.buildSortedLinkedList();
        int count = SinglyLinkedList.getLength(head);
        BinaryTreeNode root = buildBalancedBST(new SinglyLinkedListNode[]{head}, count);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }

        System.out.println();

        head = SinglyLinkedList.build123();
        count = SinglyLinkedList.getLength(head);
        root = buildBalancedBST(new SinglyLinkedListNode[]{head}, count);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }
    }

    private static BinaryTreeNode buildBalancedBST(SinglyLinkedListNode[] head, int count)
    {
        if (count <= 0)
            return null;

        BinaryTreeNode left = buildBalancedBST(head, count >> 1);
        BinaryTreeNode root = new BinaryTreeNode(head[0].getValue(), left, null);
        head[0] = head[0].getNext();
        root.setRight(buildBalancedBST(head, count - (count >> 1) - 1));
        return root;
    }
}
