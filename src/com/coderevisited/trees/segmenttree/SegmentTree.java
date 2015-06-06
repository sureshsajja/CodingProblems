package com.coderevisited.trees.segmenttree;

/**
 * Author : Suresh
 * Date : 06/06/15.
 */

/**
 * For getting minimum.. lazy propagation
 */
public class SegmentTree {


    private final int[] array;
    private final int[] tree;
    private final int[] lazy;


    public SegmentTree(int[] array) {
        this.array = array;
        int log = (int) Math.ceil(Math.log(array.length) / Math.log(2));
        int size = 2 * (int) Math.pow(2, log) - 1;
        this.tree = new int[size];
        this.lazy = new int[size];
    }


    public void buildTree(int index, int a, int b) {

        if (a > b) {
            return;
        }
        if (a == b) {
            tree[index] = array[a];
            return;
        }
        buildTree(2 * index + 1, a, (a + b) / 2);
        buildTree(2 * index + 2, (a + b) / 2 + 1, b);
        if (tree[2 * index + 1] < tree[2 * index + 2]) {
            tree[index] = tree[2 * index + 1];
        } else
            tree[index] = tree[2 * index + 2];
    }


    public void updateTree(int index, int a, int b, int i, int j, int value) {

        if (a > b || a > j || b < i)
            return;

        if (lazy[index] != 0) {
            tree[index] += lazy[index];
            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }
            lazy[index] = 0;
        }


        if (a >= i && b <= j) {
            tree[index] += value;
            if (a != b) {
                lazy[index * 2 + 1] += value;
                lazy[index * 2 + 2] += value;
            }
            return;
        }
        if (a == b) return;
        updateTree(index * 2 + 1, a, (a + b) / 2, i, j, value);
        updateTree(index * 2 + 2, (a + b) / 2 + 1, b, i, j, value);
        if (tree[2 * index + 1] < tree[2 * index + 2]) {
            tree[index] = tree[2 * index + 1];
        } else
            tree[index] = tree[2 * index + 2];

    }

    public  int queryTree(int index, int a, int b, int i, int j) {

        if (a > b || a > j || b < i)
            return Integer.MAX_VALUE;

        if (lazy[index] != 0) {
            tree[index] += lazy[index];

            if (a != b) {
                lazy[index * 2 + 1] += lazy[index];
                lazy[index * 2 + 2] += lazy[index];
            }

            lazy[index] = 0;
        }

        if (a >= i && b <= j)
            return tree[index];

        int q1 = queryTree(index * 2 + 1, a, (a + b) / 2, i, j);
        int q2 = queryTree(index * 2 + 2, 1 + (a + b) / 2, b, i, j);

        return q1 < q2 ? q1 : q2;
    }


}
