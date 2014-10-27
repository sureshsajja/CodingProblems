package com.coderevisited.coding.arrays;

/**
 * array rotation using auxiliary space o(d)
 * time complexity o(1)
 */
public class ArrayRotationNaive
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        rotateArray(array, 4);
        System.out.println("contents after rotation : ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] array, int d)
    {
        int[] temp = new int[d];

        //copy array contents from 0 to d-1 position to a temp array
        System.arraycopy(array, 0, temp, 0, d);

        //move array contents from d to array.length - d -1 position
        System.arraycopy(array, d, array, 0, array.length - d);

        //copy temp array contents from position array.length - d to array.length
        System.arraycopy(temp, 0, array, array.length - d, d);

    }
}
