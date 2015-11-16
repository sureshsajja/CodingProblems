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

package com.coderevisited.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversal
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        System.out.println("Pre-order traversal:");
        printPreOrder(root);
        System.out.println();
        System.out.println("In-order traversal:");
        printInOrder(root);
        System.out.println();
        System.out.println("Post-order traversal:");
        printPostOder(root);
        System.out.println();
        System.out.println("level-order traversal:");
        printLevelOrder(root);
        System.out.println();
        System.out.println("Spiral-order traversal:");
        printSpiralOder(root);

    }

    /**
     * root -> left sub tree -> right sub tree
     */
    public static void printPreOrder(BinaryTreeNode node)
    {
        if (node == null) {
            return;
        }
        System.out.print(node.getValue() + " ");
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());

    }

    /**
     * left sub tree -> root --> right sub tree
     */
    public static void printInOrder(BinaryTreeNode node)
    {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.print(node.getValue() + " ");
        printInOrder(node.getRight());
    }

    /**
     * Left sub tree -> right sub tree -> root
     */
    public static void printPostOder(BinaryTreeNode node)
    {
        if (node == null) {
            return;
        }
        printPostOder(node.getLeft());
        printPostOder(node.getRight());
        System.out.print(node.getValue() + " ");

    }

    public static void printLevelOrder(BinaryTreeNode node)
    {
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        if (node != null) {
            bfsQueue.add(node);
        }
        while (!bfsQueue.isEmpty()) {
            BinaryTreeNode n = bfsQueue.poll();
            System.out.print(n.getValue() + " ");
            if (n.getLeft() != null) {
                bfsQueue.add(n.getLeft());
            }
            if (n.getRight() != null) {
                bfsQueue.add(n.getRight());
            }
        }
        System.out.println();
    }

    public static void printSpiralOder(BinaryTreeNode node)
    {
        //S1 for processing odd levels i.e from right to left
        Stack<BinaryTreeNode> s1 = new Stack<>();
        //S2 for processing even levels i.e left to right
        Stack<BinaryTreeNode> s2 = new Stack<>();
        if (node != null) {
            s1.push(node);
            //root is added
        }


        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                //in the first traversal, root is removed
                BinaryTreeNode n = s1.pop();
                System.out.print(n.getValue() + " ");
                //add all children from right to left
                //when you pop.. the order will be left to right
                if (n.getRight() != null) {
                    s2.push(n.getRight());
                }
                if (n.getLeft() != null) {
                    s2.push(n.getLeft());
                }
            }

            while (!s2.isEmpty()) {
                BinaryTreeNode n = s2.pop();
                System.out.print(n.getValue() + " ");
                //add all children from left to right
                //when you pop.. the order will be right to left
                if (n.getLeft() != null) {
                    s1.push(n.getLeft());
                }
                if (n.getRight() != null) {
                    s1.push(n.getRight());
                }

            }
        }
    }
}
