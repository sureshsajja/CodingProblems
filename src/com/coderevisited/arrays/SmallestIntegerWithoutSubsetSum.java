package com.coderevisited.arrays;

public class SmallestIntegerWithoutSubsetSum
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 3, 6, 10, 11, 15};
        int value = findSmallest(array);
        System.out.println("Smallest integer that can't be represented as sum of any subset : " + value);

    }

    private static int findSmallest(int[] array)
    {
        int value = 1;
        for (int anArray : array) {
            if (anArray > value)
                return value;
            else {
                value = anArray + value;
            }
        }
        return value;
    }
}
