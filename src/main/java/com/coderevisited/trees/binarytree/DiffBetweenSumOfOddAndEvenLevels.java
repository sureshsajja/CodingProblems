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

public class DiffBetweenSumOfOddAndEvenLevels
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        int diff = diffBetweenOddAndEvenLevels(root);
        System.out.println("Difference between odd and even levels : " + diff);

        diff = diffBetweenOddAndEvenLevelsRecursive(root);
        System.out.println("Difference between odd and even levels by recursive : " + diff);
    }

    public static int diffBetweenOddAndEvenLevels(BinaryTreeNode root)
    {
        int odd = 0;
        int even = 0;
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        Queue<Integer> levelQueue = new LinkedList<>();
        levelQueue.add(1);
        while (!bfsQueue.isEmpty())
        {
            BinaryTreeNode node = bfsQueue.poll();
            int level = levelQueue.poll();
            if ((level & 1) != 0)
            {
                odd += node.getValue();
            } else
            {
                even += node.getValue();
            }

            if (node.getLeft() != null)
            {
                bfsQueue.add(node.getLeft());
                levelQueue.add(level + 1);
            }
            if (node.getRight() != null)
            {
                bfsQueue.add(node.getRight());
                levelQueue.add(level + 1);
            }
        }

        return odd - even;
    }

    public static int diffBetweenOddAndEvenLevelsRecursive(BinaryTreeNode root)
    {
        if (root != null)
        {
            return root.getValue() - diffBetweenOddAndEvenLevelsRecursive(root.getLeft()) - diffBetweenOddAndEvenLevelsRecursive(root.getRight());
        }
        return 0;
    }
}
