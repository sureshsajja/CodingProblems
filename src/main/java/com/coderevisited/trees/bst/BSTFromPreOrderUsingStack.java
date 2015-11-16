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

import java.util.Stack;

/**
 * 1. Push first node as root to stack
 * 2. for each int  i from pre-order, pop from stack until we found top element is greater than  i
 * 3. if last pop element is not null, set i as right child
 * 4. if last pop is null, set i as left child to the peek.
 * 5. add newly constructed node to stack
 */
public class BSTFromPreOrderUsingStack
{
    public static void main(String[] args)
    {
        int[] preOrder = new int[]{10, 5, 1, 7, 40, 50};
        BinaryTreeNode root = constructBST(preOrder);
        BinaryTreeTraversal.printInOrder(root);
    }

    private static BinaryTreeNode constructBST(int[] preOrder)
    {
        Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
        BinaryTreeNode root = null;
        if (preOrder.length >= 1) {
            root = new BinaryTreeNode(preOrder[0], null, null);
            stack.push(root);
        }
        for (int i = 1; i < preOrder.length; i++) {

            BinaryTreeNode peek = null;
            while (!stack.isEmpty() && preOrder[i] > stack.peek().getValue()) {
                peek = stack.pop();
            }
            BinaryTreeNode node = new BinaryTreeNode(preOrder[i], null, null);

            if (peek != null) {
                peek.setRight(node);
            }
            if (peek == null) {
                peek = stack.peek();
                peek.setLeft(node);
            }
            stack.push(node);
        }
        return root;
    }
}
