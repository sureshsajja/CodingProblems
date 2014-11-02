package com.coderevisited.searching;

public class SortInAlmostSortedArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{10, 3, 40, 20, 50, 80, 70};

        for (int i : array) {
            int index = searchInArray(array, i);
            if (index != -1)
                System.out.println("key " + (i) + " found at index : " + index);
            else
                System.out.println("key " + (i) + " not found");
        }
    }

    private static int searchInArray(int[] array, int key)
    {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key)
                return mid;
            else if (mid > 0 && array[mid - 1] == key)
                return mid - 1;
            else if (mid <= array.length - 1 && array[mid + 1] == key)
                return mid + 1;
            else if (array[mid] > key)
                high = mid - 2;
            else if (array[mid] < key)
                low = mid + 2;
            else return -1;
        }
        return -1;
    }
}
