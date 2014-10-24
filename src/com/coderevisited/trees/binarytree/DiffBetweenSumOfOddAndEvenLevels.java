package com.coderevisited.trees.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class DiffBetweenSumOfOddAndEvenLevels
{

    public static void main(String[] args)
    {
        BinaryTreeNode root = BinaryTree.buildTree();
        int diff = diffBetweenOddAndEvenLevels(root);
        System.out.println("Difference between odd and even levels : " + diff);

        diff = diffBetweenOddAndEvenLevelsRecursive(root);
        System.out.println("Difference between odd and even levels by recursive : " + diff);
    }

    public static int diffBetweenOddAndEvenLevels(BinaryTreeNode root)
    {
        int odd = 0;
        int even = 0;
        Queue<BinaryTreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        Queue<Integer> levelQueue = new LinkedList<>();
        levelQueue.add(1);
        while (!bfsQueue.isEmpty())
        {
            BinaryTreeNode node = bfsQueue.poll();
            int level = levelQueue.poll();
            if ((level & 1) != 0)
            {
                odd += node.getValue();
            } else
            {
                even += node.getValue();
            }

            if (node.getLeft() != null)
            {
                bfsQueue.add(node.getLeft());
                levelQueue.add(level + 1);
            }
            if (node.getRight() != null)
            {
                bfsQueue.add(node.getRight());
                levelQueue.add(level + 1);
            }
        }

        return odd - even;
    }

    public static int diffBetweenOddAndEvenLevelsRecursive(BinaryTreeNode root)
    {
        if (root != null)
        {
            return root.getValue() - diffBetweenOddAndEvenLevelsRecursive(root.getLeft()) - diffBetweenOddAndEvenLevelsRecursive(root.getRight());
        }
        return 0;
    }
}
