package com.coderevisited.searching;

public class DuplicateCount
{
    public static void main(String[] args)
    {
        int[] array = new int[]{0, 0, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 4};

        int min = leastIndexBinarySearch(array, 0, array.length - 1, 1);
        int max = maxIndexBinarySearch(array, 0, array.length - 1, 1);
        System.out.println("min:" + min);
        System.out.println("max:" + max);
        if (min != -1 && max != -1)
            System.out.println(max - min + 1);
        else {
            System.out.println("Key not found");
        }
    }

    public static int leastIndexBinarySearch(int[] array, int low, int high, int key)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((array[mid] == key) && (mid == 0 || array[mid - 1] < key)) {
                return mid;
            }
            if (array[mid] < key) {
                low = mid + 1;
            } else
                high = mid - 1;
        }
        return -1;
    }

    public static int maxIndexBinarySearch(int[] array, int low, int high, int key)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((array[mid] == key) && (mid == array.length - 1 || array[mid + 1] > key)) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return -1;
    }
}
