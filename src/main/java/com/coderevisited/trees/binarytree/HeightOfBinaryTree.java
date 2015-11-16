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

public class HeightOfBinaryTree
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildSkewedTree();
        int height = findHeight(root);
        System.out.println("Height of the tree by Iterative method : " + height);
        height = findHeightRecursive(root);
        System.out.println("Height of the tree by Recursive method : " + height);
    }

    private static int findHeightRecursive(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        int hl = findHeightRecursive(root.getLeft());
        int hr = findHeightRecursive(root.getRight());
        if (hl > hr)
            return 1 + hl;
        else
            return 1 + hr;
    }

    private static int findHeight(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        Queue<Integer> heightQueue = new LinkedList<>();
        bfsQueue.add(root);
        int height = 1;
        heightQueue.add(1);
        while (!bfsQueue.isEmpty()) {
            BinaryTreeNode node = bfsQueue.poll();
            height = heightQueue.poll();
            if (node.getLeft() != null) {
                bfsQueue.add(node.getLeft());
                heightQueue.add(height + 1);
            }
            if (node.getRight() != null) {
                bfsQueue.add(node.getRight());
                heightQueue.add(height + 1);
            }
        }
        return height;
    }
}
