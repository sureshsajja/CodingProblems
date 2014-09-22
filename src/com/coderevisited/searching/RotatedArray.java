package com.coderevisited.searching;

public class RotatedArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4};
        //int[] array = new int[]{5, 6, 1, 2, 3, 4};
        // int[] array = new int[]{1, 0, 2, 3, 4};
        //int[] array = new int[]{2, 1};
        // int[] array = new int[]{1};
        //int[] array = new int[]{1, 2};
        //int[] array = new int[]{5, 6, 7, 1, 2, 3, 4};
        // int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        // int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        //  int[] array = new int[]{3, 4, 5, 1, 2};
        // int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
        //int[] array = new int[]{2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        // int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
        // int[] array = new int[]{3, 3, 3, 4, 4, 4, 4, 5, 3, 3};
        // int[] array = new int[]{1, 1, 2, 2, 3};
        //  int[] array = new int[]{1, 1, 0, 1};

        int min = findMin(array, 0, array.length - 1);
        int a = -1;
        if (min > 0) {
            a = binarySearch(array, 0, min - 1, 4);
        }
        if (a == -1)
            a = binarySearch(array, min, array.length - 1, 4);

        System.out.println(a);

    }

    private static int findMin(int[] array, int low, int high)
    {
        if (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > low && array[mid] < array[mid - 1]) {
                return mid;
            }
            if (mid < high && array[mid + 1] < array[mid])
                return mid + 1;

            if (array[high] > array[mid]) {
                return findMin(array, low, mid - 1);
            } else if (array[high] < array[mid])
                return findMin(array, mid + 1, high);
            else {
                int a = findMin(array, mid + 1, high);
                int b = findMin(array, low, mid - 1);
                if (array[a] < array[b])
                    return a;
                else
                    return b;
            }
        }
        return low;
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
