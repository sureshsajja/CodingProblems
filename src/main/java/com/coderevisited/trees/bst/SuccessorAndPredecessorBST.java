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

import com.coderevisited.trees.binarytree.BinaryTree;
import com.coderevisited.trees.binarytree.BinaryTreeNode;

public class SuccessorAndPredecessorBST
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        BinaryTreeNode[] nodes = new BinaryTreeNode[2];
        findInOrderSucAndPre(root, 7, nodes);
        if (nodes[0] != null) {
            System.out.println("Successor of 7 : " + nodes[0].getValue());
        } else {
            System.out.println("No Successor for 7 ");
        }

        if (nodes[1] != null) {
            System.out.println("Predecessor of 7 : " + nodes[1].getValue());
        } else {
            System.out.println("No Predecessor for 7 ");
        }
    }

    private static void findInOrderSucAndPre(BinaryTreeNode root, int k, BinaryTreeNode[] nodes)
    {
        if (root == null)
            return;
        if (root.getValue() == k) {
            if (root.getRight() != null) {
                BinaryTreeNode temp = root.getRight();
                while (temp.getLeft() != null) {
                    temp = temp.getLeft();
                }
                nodes[0] = temp;
            }

            if (root.getLeft() != null) {
                BinaryTreeNode temp = root.getLeft();
                while (temp.getRight() != null) {
                    temp = temp.getRight();
                }
                nodes[1] = temp;
            }

            return;
        }
        if (root.getValue() > k) {
            nodes[0] = root;
            findInOrderSucAndPre(root.getLeft(), k, nodes);
        } else {
            nodes[1] = root;
            findInOrderSucAndPre(root.getRight(), k, nodes);
        }
    }
}
