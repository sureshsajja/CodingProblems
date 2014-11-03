package com.coderevisited.trees.bst;

import com.coderevisited.trees.binarytree.BinaryTreeNode;
import com.coderevisited.trees.binarytree.BinaryTreeTraversal;

/**
 * 1. Start from first integer as root and set left child range as MIN, root. set right child range as root, MAX 2. At
 * each step we verify if the given key is in the range, then create node and make calls for left and right child 3. To
 * keep track of index, we use array of size 1 because at each point we should not go back to already processed key
 */
public class BSTFromPreOrderTraversal
{
    public static void main(String[] args)
    {
        int[] preOrder = new int[]{10, 5, 1, 7, 40, 50};
        BinaryTreeNode root = constructBST(preOrder, new int[]{0}, Integer.MIN_VALUE, Integer.MAX_VALUE, preOrder[0]);
        BinaryTreeTraversal.printInOrder(root);
    }

    public static BinaryTreeNode constructBST(int[] preOrder, int[] index, int min, int max, int key)
    {
        if (index[0] >= preOrder.length) {
            return null;
        }
        BinaryTreeNode root = null;
        if (min < key && max > key) {
            root = new BinaryTreeNode(preOrder[index[0]], null, null);
            index[0] = index[0] + 1;
            if (index[0] < preOrder.length) {
                root.setLeft(constructBST(preOrder, index, min, key, preOrder[index[0]]));
                root.setRight(constructBST(preOrder, index, key, max, preOrder[index[0]]));
            }
        }
        return root;
    }
}
