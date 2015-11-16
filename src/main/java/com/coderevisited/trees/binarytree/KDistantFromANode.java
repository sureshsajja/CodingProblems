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

public class KDistantFromANode
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printKDistantNodes(root, 4, 3);
    }

    public static int printKDistantNodes(BinaryTreeNode node, int target, int k)
    {
        if (node == null)
            return -1;

        if (node.getValue() == target) {
            KDistantFromRoot.printKDistantFromRoot(node, k);
            return 0;
        }
        //distance of target node from left child
        int left = printKDistantNodes(node.getLeft(), target, k);
        if (left >= 0) {

            if (left + 1 == k)
                System.out.print(node.getValue() + " ");
            else
                KDistantFromRoot.printKDistantFromRoot(node.getRight(), k - left - 2);

            //It is 1+left distant from node
            return 1 + left;

        }
        //distance of target node from right child
        int right = printKDistantNodes(node.getRight(), target, k);
        if (right >= 0) {

            if (right + 1 == k)
                System.out.print(node.getValue() + " ");
            else
                KDistantFromRoot.printKDistantFromRoot(node.getLeft(), k - right - 2);

            //It is 1+right distant from node
            return 1 + right;

        }

        return -1;
    }
}
