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

/**
 * While serializing add -1 for null children Deserialize array by considering -1 as leafs
 */
public class SerializeAndDeserializer
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        System.out.println("Pre order traversal : ");
        BinaryTreeTraversal.printPreOrder(root);
        System.out.println();
        System.out.println("Serialization of Binary Tree");
        serialize(root);
        System.out.println();
        System.out.println("Deserializing ... ");
        int[] array = new int[]{6, 2, 11, -1, -1, 4, 3, -1, -1, 5, -1, -1, 7, -1, 19, 8, -1, -1, -1};
        root = deserializer(array, new int[]{0});
        System.out.println("Pre order traversal : ");
        BinaryTreeTraversal.printPreOrder(root);
        System.out.println();
    }

    //Reading from serialized array, if value is -1, child is null.
    private static BinaryTreeNode deserializer(int[] array, int[] index)
    {
        if (index[0] >= array.length || array[index[0]] == -1) {
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(array[index[0]], null, null);
        index[0] = index[0] + 1;
        root.setLeft(deserializer(array, index));
        index[0] = index[0] + 1;
        root.setRight(deserializer(array, index));

        return root;

    }

    //Save PreOrder traversal by inserting -1 for null values
    private static void serialize(BinaryTreeNode root)
    {
        if (root == null) {
            System.out.print("-1 ");
            return;
        }

        System.out.print(root.getValue() + " ");
        serialize(root.getLeft());
        serialize(root.getRight());
    }
}
