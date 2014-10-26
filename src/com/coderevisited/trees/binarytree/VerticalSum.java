package com.coderevisited.trees.binarytree;

import java.util.HashMap;

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
        int sum = map.get(index);
        sum += root.getValue();
        map.put(index, sum);
        findVerticalSum(root.getLeft(), map, index - 1);
        findVerticalSum(root.getRight(), map, index + 1);

    }
}
