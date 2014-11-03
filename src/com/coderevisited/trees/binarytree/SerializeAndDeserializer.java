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
