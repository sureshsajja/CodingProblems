package com.coderevisited.arrays.rotation;

/**
 * Initialize A = arr[0..d-1] and B = arr[d..n-1]
 * 1) Do following until size of A is equal to size of B
 * <p/>
 * a)  If A is shorter, divide B into Bl and Br such that Br is of same
 * length as A. Swap A and Br to change ABlBr into BrBlA. Now A
 * is at its final place, so recur on pieces of B.
 * <p/>
 * b)  If A is longer, divide A into Al and Ar such that Al is of same
 * length as B Swap Al and B to change AlArB into BArAl. Now B
 * is at its final place, so recur on pieces of A.
 * <p/>
 * 2)  Finally when A and B are of equal size, block swap them.
 */

public class ArrayRotationBlockSwap
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotateArray(array, 4);
        System.out.println("contents after rotation : ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] array, int d)
    {

        int i, j;
        if (d == 0 || d == array.length)
            return;
        i = d;
        j = array.length - d;
        while (i != j) {
             /*A is shorter*/
            if (i < j) {
                swap(array, d - i, d + j - i, i);
                j -= i;
            } else {
                /*B is shorter*/
                swap(array, d - i, d, j);
                i -= j;
            }
        }
        /*Finally, block swap A and B*/
        swap(array, d - i, d, i);

    }


    private static void swap(int array[], int i, int j, int d)
    {
        int k, temp;
        for (k = 0; k < d; k++) {
            temp = array[i + k];
            array[i + k] = array[j + k];
            array[j + k] = temp;
        }
    }
}
