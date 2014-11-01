package com.coderevisited.arrays.rotation;

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
