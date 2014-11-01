package com.coderevisited.arrays.rotation;

/**
 * http://www.cs.bell-labs.com/cm/cs/pearls/s02b.pdf
 */
public class ArrayRotationReversal
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
        reverse(array, 0, d - 1);
        reverse(array, d, array.length - 1);
        reverse(array, 0, array.length - 1);
    }


    private static void reverse(int[] array, int start, int end)
    {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;

        }
    }
}
