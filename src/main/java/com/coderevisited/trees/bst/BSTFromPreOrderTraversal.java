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

import com.coderevisited.trees.binarytree.BinaryTreeNode;
import com.coderevisited.trees.binarytree.BinaryTreeTraversal;

/**
 * 1. Start from first integer as root and set left child range as MIN, root. set right child range as root, MAX
 * 2. At each step we verify if the given key is in the range, then create node and make calls for left and right child
 * 3. To keep track of index, we use array of size 1 because at each point we should not go back to already processed key
 */
public class BSTFromPreOrderTraversal
{
    public static void main(String[] args)
    {
        int[] preOrder = new int[]{10, 5, 1, 7, 40, 50};
        BinaryTreeNode root = constructBST(preOrder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE);
        BinaryTreeTraversal.printInOrder(root);
    }

    public static BinaryTreeNode constructBST(int[] preOrder, int[] index, int min, int max)
    {
        if (index[0] >= preOrder.length) {
            return null;
        }
        BinaryTreeNode root = null;
        int key = preOrder[index[0]];
        if (min < key && max > key) {
            root = new BinaryTreeNode(preOrder[index[0]], null, null);
            index[0] = index[0] + 1;
            if (index[0] < preOrder.length) {
                root.setLeft(constructBST(preOrder, index, min, key));
                root.setRight(constructBST(preOrder, index, key, max));
            }
        }
        return root;
    }
}
