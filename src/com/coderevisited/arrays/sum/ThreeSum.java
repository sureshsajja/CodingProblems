package com.coderevisited.arrays.sum;

import com.coderevisited.searching.BinarySearch;

import java.util.Arrays;

/**
 * Find Triplet
 * 1. Sort the given array
 * 2. for each element 'i' from 0 to array.length - 3
 * 3. find if there exists any pair whose sum is equal to 'SUM - array[i]'
 * <p/>
 * To find all pairs
 * ================
 * for each element 'i' from 0 to array.length - 3
 * for each element 'j' from i+1, to array.length - 2
 * find there exists any element 'k' whose value is 'SUM - array[i]-array[k]
 */
public class ThreeSum
{
    public static void main(String[] args)
    {
        int[] array = new int[]{12, 3, 4, 1, 6, 9, 20, 7, 16};
        findTriplet(array, 24);
        System.out.println("Now finding all pairs ..");
        findAllTriplet(array, 24);
    }

    private static void findTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            int k = array.length - 1;

            while (j < k) {
                if (array[i] + array[j] + array[k] == sum) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[j] + ", " + array[k]);
                    return;
                } else if (array[i] + array[j] + array[k] > sum) {
                    k--;
                } else if (array[i] + array[j] + array[k] < sum) {
                    j++;
                }
            }
        }
    }

    private static void findAllTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                int k = BinarySearch.binarySearch(array, j + 1, array.length - 1, sum - array[j] - array[i]);
                if (k > 0) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[j] + ", " + array[k]);
                }
            }
        }
    }
}
