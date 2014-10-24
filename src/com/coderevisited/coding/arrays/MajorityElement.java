package com.coderevisited.coding.arrays;

public class MajorityElement
{
    public static void main(String[] args)
    {
        int[] array = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};
        int index = findMajority(array);
        if (index > 0) {
            System.out.println("majority element: " + array[index]);
        } else {
            System.out.println("No Majority element");
        }
    }

    private static int findMajority(int[] array)
    {
        int index = 0;
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == array[index]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    index = i;
                }
            }
        }

        int majority = array[index];
        count = 0;
        for (int i : array) {
            if (i == majority) {
                count++;
            }
        }

        if (count > array.length / 2)
            return index;
        else
            return -1;


    }
}
