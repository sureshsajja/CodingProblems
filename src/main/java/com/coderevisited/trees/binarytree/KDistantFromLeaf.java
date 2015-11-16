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

public class KDistantFromLeaf
{
    private static final int MAX_HEIGHT = 10;

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printKDistantFromLeaf(root, new int[MAX_HEIGHT], new boolean[MAX_HEIGHT], 3, 0);
    }


    private static void printKDistantFromLeaf(BinaryTreeNode node, int[] path, boolean[] visited, int k, int len)
    {
        if (node == null)
            return;

        path[len] = node.getValue();
        visited[len] = false;

        if (node.getLeft() == null && node.getRight() == null && len - k >= 0 && !visited[len - k]) {
            System.out.print(path[len - k] + " ");
            visited[len - k] = true;
        }

        printKDistantFromLeaf(node.getLeft(), path, visited, k, len + 1);
        printKDistantFromLeaf(node.getRight(), path, visited, k, len + 1);

    }
}
