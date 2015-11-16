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

public class BinarySearchTreeLCA
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildBST();
        System.out.println("LCA(1,8) : " + findLCA(1, 8, root));
    }

    private static int findLCA(int n1, int n2, BinaryTreeNode node)
    {
        BinaryTreeNode lca = findLCAUtil(n1, n2, node);
        //Check if n1 is actually exists
        if (find(n1, lca) && find(n2, lca))
            return lca.getValue();
        return -1;
    }

    public static boolean find(int n, BinaryTreeNode node)
    {
        if (node == null)
            return false;
        if (node.getValue() == n)
            return true;
        if (node.getValue() < n)
            return find(n, node.getRight());
        else
            return find(n, node.getLeft());
    }

    private static BinaryTreeNode findLCAUtil(int n1, int n2, BinaryTreeNode root)
    {
        if (root == null)
            return null;
        //Check if n1, n2 are left side of the BST
        if (root.getValue() > n1 && root.getValue() > n2) {
            return findLCAUtil(n1, n2, root.getLeft());
        }

        //Check if n1, n2 are right side of the BST
        if (root.getValue() < n1 && root.getValue() < n2) {
            return findLCAUtil(n1, n2, root.getRight());
        }
        //n1, n2 are not in the same side. so root is the LCA
        return root;
    }
}
