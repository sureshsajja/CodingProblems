package com.coderevisited.trees.binarytree;


import java.util.LinkedList;
import java.util.Queue;

public class LinkToNextNodeInLevelOrder
{
    public static void main(String[] args)
    {
        BinaryTreeNodeExtended root = BinaryTree.buildTreeExtended();
        linkToNextNodeInLevelOrder(root);
        System.out.println(root.getValue());
    }

    private static void linkToNextNodeInLevelOrder(BinaryTreeNodeExtended root)
    {
        Queue<BinaryTreeNodeExtended> bfsQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        if (root != null) {
            bfsQueue.add(root);
            levelQueue.add(1);
        }

        while (!bfsQueue.isEmpty()) {
            BinaryTreeNodeExtended node = bfsQueue.poll();
            int level = levelQueue.poll();
            BinaryTreeNodeExtended peek = bfsQueue.peek();
            if (peek != null) {
                int peekLevel = levelQueue.peek();
                if (peekLevel == level) {
                    node.setNextRight(peek);
                }
            }
            if (node.getLeft() != null) {
                bfsQueue.add(node.getLeft());
                levelQueue.add(level + 1);
            }

            if (node.getRight() != null) {
                bfsQueue.add(node.getRight());
                levelQueue.add(level + 1);
            }
        }
    }

}
