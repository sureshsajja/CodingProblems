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

public class LinkToNextNodeInLevelOrder
{
    public static void main(String[] args)
    {
        BinaryTreeNodeExtended root = BinaryTree.buildTreeExtended();
        BinaryTreeTraversal.printLevelOrder(root);
        System.out.println("Linking next nodes in level order traversal");
        linkToNextNodeInLevelOrder(root);

        System.out.println(((BinaryTreeNodeExtended) (root.getLeft())).getNextRight().getValue());
    }

    private static void linkToNextNodeInLevelOrder(BinaryTreeNodeExtended root)
    {
        Queue<BinaryTreeNodeExtended> bfsQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        if (root != null) {
            bfsQueue.add(root);
            levelQueue.add(1);
        }

        while (!bfsQueue.isEmpty()) {
            //Remove first node from queue
            BinaryTreeNodeExtended node = bfsQueue.poll();
            //get level of this node
            int level = levelQueue.poll();
            //get next node in queue
            BinaryTreeNodeExtended peek = bfsQueue.peek();
            if (peek != null) {
                //If there is a next node.
                int peekLevel = levelQueue.peek();
                if (peekLevel == level) {
                    //if levels are same. link it
                    node.setNextRight(peek);
                }
            }
            //recur left
            if (node.getLeft() != null) {
                bfsQueue.add((BinaryTreeNodeExtended) node.getLeft());
                levelQueue.add(level + 1);
            }

            //recur right
            if (node.getRight() != null) {
                bfsQueue.add((BinaryTreeNodeExtended) node.getRight());
                levelQueue.add(level + 1);
            }
        }
    }

}
