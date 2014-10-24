package com.coderevisited.coding.sum;

import java.util.Arrays;

public class Triplet
{
    public static void main(String[] args)
    {
        int[] array = new int[]{12, 3, 4, 1, 6, 9};
        findTriplet(array, 24);
        findAllTriplet(array, 24);
    }

    private static void findTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int b = i + 1;
            int c = array.length - 1;

            while (b < c) {
                if (array[i] + array[b] + array[c] == sum) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[b] + ", " + array[c]);
                    return;
                } else if (array[i] + array[b] + array[c] > sum) {
                    c--;
                } else if (array[i] + array[b] + array[c] < sum) {
                    b++;
                }
            }
        }
    }

    private static void findAllTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                int k = Arrays.binarySearch(array, j + 1, array.length, sum - array[j] - array[i]);
                if (k > 0) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[j] + ", " + array[k]);
                }
            }
        }
    }
}
