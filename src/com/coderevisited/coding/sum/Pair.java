package com.coderevisited.coding.sum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2-SUM problem
 */
public class Pair
{

    public static void main(String[] args)
    {

        //distinct integers
        int[] array = new int[]{1, 4, 45, 6, 10, -8};
        int[] result = findTwoSum(array, 16);
        if (result != null)
        {
            System.out.println("values that make the given sum : " + result[0] + " and " + result[1]);
        }

        findAllPairs(array, 16);

        findAllPairsByHashing(array, 16);

    }

    private static void findAllPairsByHashing(int[] array, int sum)
    {
        Set<Integer> set = new HashSet<>(array.length);
        for (int i : array)
        {
            if (set.contains(sum - i))
            {
                System.out.println("values that make the given sum : " + i + " and " + (sum - i));
            }
            set.add(i);
        }

    }

    public static int[] findTwoSum(int[] array, int sum)
    {
        Arrays.sort(array);

        int low = 0, high = array.length - 1;

        while (low < high)
        {
            if (array[low] + array[high] == sum)
            {
                return new int[]{array[low], array[high]};
            } else if (array[low] + array[high] > sum)
            {
                high--;
            } else if (array[low] + array[high] < sum)
            {
                low++;
            }
        }

        return null;
    }

    public static void findAllPairs(int[] array, int sum)
    {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++)
        {
            int toFind = sum - array[i];
            int returned = Arrays.binarySearch(array, i + 1, array.length, toFind);
            if (returned > 0)
            {
                System.out.println("values that make the given sum :  " + array[i] + " , " + array[returned]);
            }
        }

    }

}
