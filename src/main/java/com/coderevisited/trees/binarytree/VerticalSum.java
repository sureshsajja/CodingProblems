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

import java.util.HashMap;

/**
 * 1. Initialize a Hashmap.
 * 2. root index is 0
 * 3. Left Child index = root index - 1;
 * 4. Right child index = root index + 1
 * 5. Update count in map
 */
public class VerticalSum
{
    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        printVerticalSum(root);
    }

    private static void printVerticalSum(BinaryTreeNode root)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        findVerticalSum(root, map, 0);
        System.out.println(map.entrySet());
    }

    private static void findVerticalSum(BinaryTreeNode root, HashMap<Integer, Integer> map, int index)
    {

        if (root == null)
            return;

        if (!map.containsKey(index)) {
            map.put(index, 0);
        }
        //Update root sum
        int sum = map.get(index);
        sum += root.getValue();
        map.put(index, sum);
        //Recur left and right
        findVerticalSum(root.getLeft(), map, index - 1);
        findVerticalSum(root.getRight(), map, index + 1);

    }
}
