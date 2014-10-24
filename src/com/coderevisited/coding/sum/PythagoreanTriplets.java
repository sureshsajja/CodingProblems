package com.coderevisited.coding.sum;

import java.util.Arrays;

public class PythagoreanTriplets
{
    public static void main(String[] args)
    {
        int[] array = new int[]{9, 2, 3, 4, 8, 5, 6, 10};
        findTriplets(array);
    }

    private static void findTriplets(int[] array)
    {
        for (int i = 0; i < array.length; i++) {
            array[i] *= array[i];
        }

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int a = array[i];
            for (int j = i + 1; j < array.length - 1; j++) {
                int b = array[j];
                int returned = Arrays.binarySearch(array, j + 1, array.length, a + b);
                if (returned > 0) {
                    System.out.println("values that make the given sum :  " + (int) Math.sqrt(a) + ", " + (int) Math.sqrt(b) + ", " + (int) Math.sqrt(array[returned]));
                }
            }
        }
    }
}
