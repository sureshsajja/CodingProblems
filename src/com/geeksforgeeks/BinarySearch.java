package com.geeksforgeeks;

import java.util.Arrays;

public class BinarySearch
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        Arrays.sort(array);
        System.out.println(binarySearch(array, 0, array.length - 1, 12));
    }

    private static int binarySearch(int[] array, int low, int high, int key)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key)
                return mid;
            else if (array[mid] > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;

    }
}
