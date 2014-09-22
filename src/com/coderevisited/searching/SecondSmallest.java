package com.coderevisited.searching;

public class SecondSmallest
{
    public static void main(String[] args)
    {
        int[] array = new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 0};

        System.out.println(findSecondSmallest(array, 0, array.length - 1));
    }

    private static int findSecondSmallest(int[] array, int low, int high)
    {
        int small = Integer.MAX_VALUE;
        int secondSmall = Integer.MAX_VALUE;

        for (int i = low; i <= high; i++) {
            if (array[i] < small) {
                secondSmall = small;
                small = array[i];
            } else if (array[i] < secondSmall) {
                secondSmall = array[i];
            }
        }
        return secondSmall;
    }
}
