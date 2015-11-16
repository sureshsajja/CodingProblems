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

public class BinaryTreeLCA
{
    public static void main(String[] args)
    {

        BinaryTreeNode root = BinaryTree.buildTree();

        System.out.println("LCA(5,11) : " + findLCA(5, 11, root));
        System.out.println("LCA(1,9) : " + findLCA(1, 9, root));
        System.out.println("LCA(3,8) : " + findLCA(3, 8, root));


        System.out.println("LCA(5,11) : " + findLCASingleTraversal(5, 11, root));
        System.out.println("LCA(1,9) : " + findLCASingleTraversal(1, 9, root));
        System.out.println("LCA(3,8) : " + findLCASingleTraversal(3, 8, root));

    }

    public static int findLCASingleTraversal(int n1, int n2, BinaryTreeNode root)
    {
        boolean[] found = new boolean[2];
        BinaryTreeNode lca = findLCASingleTraversalUtil(n1, n2, root, found);
        //verify if both nodes are present
        if (found[0] && found[1] || found[1] && BinaryTreeSearch.ifExists(n1, lca) || found[0] && BinaryTreeSearch.ifExists(n2, lca)) {
            return lca.getValue();
        } else {
            return -1;
        }
    }

    public static BinaryTreeNode findLCASingleTraversalUtil(int n1, int n2, BinaryTreeNode node, boolean[] found)
    {

        if (node == null) {
            return null;
        }

        //If we find n1 or n2.. this is the LCA
        if (node.getValue() == n1) {
            found[0] = true;
            return node;

        }

        if (node.getValue() == n2) {
            found[1] = true;
            return node;
        }


        //find if n1 or n2 are in the left sub tree
        BinaryTreeNode left = findLCASingleTraversalUtil(n1, n2, node.getLeft(), found);
        //find if n1 or n2 are in the right sub tree
        BinaryTreeNode right = findLCASingleTraversalUtil(n1, n2, node.getRight(), found);

        if (left != null && right != null) {
            //one node is in the left sub tree and another node is in the right sub tree
            return node;
        }

        //return node which is not -1
        if (left != null)
            return left;

        else return right;

    }

    public static int findLCA(int n1, int n2, BinaryTreeNode root)
    {
        List<BinaryTreeNode> path1 = new LinkedList<>();
        List<BinaryTreeNode> path2 = new LinkedList<>();
        int lca = -1;
        if (BinaryTreeSearch.searchForPath(n1, path1, root)) {
            if (BinaryTreeSearch.searchForPath(n2, path2, root)) {
                //If we find path of two nodes, return the last common node
                for (int i = 0; i < path1.size() && i < path2.size(); i++) {
                    if (path1.get(i).getValue() != path2.get(i).getValue()) {
                        lca = path1.get(i - 1).getValue();
                        break;
                    }
                }
            }
        }
        return lca;
    }

}
