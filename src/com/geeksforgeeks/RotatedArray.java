package com.geeksforgeeks;

public class RotatedArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{7, 8, 9, 10, 1, 2, 3, 4, 5, 6};

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
            if (mid > 0 && array[mid] < array[mid - 1]) {
                return mid;
            } else {
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
