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
import com.coderevisited.trees.binarytree.IsBalancedBinaryTree;

public class SortedArrayToBalancedBST
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTreeNode root = constructBalancedBST(array, 0, array.length - 1);
        if (IsBalancedBinaryTree.isHeightBalanced(root, new int[]{0})) {
            if (IsBST.checkIfBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
                BinaryTreeTraversal.printPreOrder(root);
        }
    }

    public static BinaryTreeNode constructBalancedBST(int[] array, int low, int high)
    {

        if (low > high) {
            return null;
        }

        int mid = low + (high - low) / 2;
        BinaryTreeNode root = new BinaryTreeNode(array[mid], null, null);

        root.setLeft(constructBalancedBST(array, low, mid - 1));
        root.setRight(constructBalancedBST(array, mid + 1, high));

        return root;
    }
}
