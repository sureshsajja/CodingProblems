package com.coderevisited.arrays;

import com.coderevisited.searching.DuplicateCount;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Using hashing:
 * =============
 * Start from N - 1 to 0, at each position
 * if element is in Hash set, update index
 * else add element to set
 * return index
 * <p/>
 * using binary search :
 * ===================
 * 1. Create tempArray with array contents and sort the temp Array
 * 2. for each element in the array, do a binary search on temp array to count number of occurrences.
 * 3. If count is more than one return that index
 */
public class FirstRepeatingInteger
{
    public static void main(String[] args)
    {
        int[] array = new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10};
        int index = findRepeatingIndex(array);
        System.out.println("Index of first repeated integer " + index + " and element is " + array[index]);


        index = findRepeatingIndexBinarySearch(array);
        if (index != -1)
            System.out.println("Index of first repeated integer " + index + " and element is " + array[index]);
        else {
            System.out.println("No repeated integer");
        }

    }

    private static int findRepeatingIndexBinarySearch(int[] array)
    {
        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);

        Arrays.sort(temp);

        for (int i = 0; i < array.length; i++) {
            int min = DuplicateCount.leastIndexBinarySearch(temp, 0, temp.length - 1, array[i]);
            int max = DuplicateCount.maxIndexBinarySearch(temp, 0, temp.length - 1, array[i]);
            if (max - min != 0) {
                return i;
            }
        }

        return -1;
    }

    private static int findRepeatingIndex(int[] array)
    {
        HashSet<Integer> set = new HashSet<>();
        int index = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (set.contains(array[i])) {
                index = i;
            } else {
                set.add(array[i]);
            }
        }

        return index;
    }
}
