package com.coderevisited.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * 1. Create map with elements in B. key as value and index as value
 * 2. Implement a comparator for two integers a, b with the following logic
 * 3. if index of a, b is not null, compare indexes
 * 4. if index of a is null return 1;
 * 5. if index of b is null return -1;
 * 6. if both are null, compare a,b
 */
public class SortByComparator
{
    public static void main(String[] args)
    {
        Integer[] A = new Integer[]{2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] B = new int[]{2, 1, 8, 3};

        Arrays.sort(A, new CustomComparator(B));
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    private static class CustomComparator implements Comparator<Integer>
    {
        HashMap<Integer, Integer> map = new HashMap<>();

        public CustomComparator(int[] B)
        {
            for (int i = 0; i < B.length; i++) {
                map.put(B[i], i);
            }
        }

        @Override
        public int compare(Integer a, Integer b)
        {
            Integer index1 = map.get(a);
            Integer index2 = map.get(b);
            if (index1 != null) {
                if (index2 != null) {
                    return index1.compareTo(index2);
                } else {
                    return -1;
                }
            } else if (index2 != null) {
                return 1;
            } else {
                return a.compareTo(b);
            }
        }
    }
}
