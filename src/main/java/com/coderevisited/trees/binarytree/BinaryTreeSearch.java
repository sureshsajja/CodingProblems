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
import java.util.List;

public class BinaryTreeSearch
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        List<BinaryTreeNode> path = new LinkedList<>();
        if (searchForPath(5, path, root)) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).getValue());
                if (i <= path.size() - 2)
                    System.out.print("->");
            }
        } else {
            System.out.println("Key nt found");
        }

    }

    public static boolean ifExists(int n, BinaryTreeNode node)
    {
        return node != null && (node.getValue() == n || ifExists(n, node.getLeft()) || ifExists(n, node.getRight()));
    }


    public static boolean searchForPath(int n, List<BinaryTreeNode> path, BinaryTreeNode node)
    {
        if (node == null) {
            return false;
        }

        //Include in the path
        path.add(node);

        if (node.getValue() == n) {
            //If this is the current node, return true
            return true;
        }

        //Recursively search left sub tree and right sub tree
        if (searchForPath(n, path, node.getLeft()) || searchForPath(n, path, node.getRight())) {
            return true;
        }

        //Present node is not included in the path. Remove it
        path.remove(node);
        return false;
    }
}
