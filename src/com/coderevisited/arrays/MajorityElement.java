package com.coderevisited.arrays;

/**
 * Majority element is defined as element that appears more than N/2 times
 * 1. assume element at 0 is majority and say it's count as 1
 * 2. for each element i from 1 to N - 1
 * 3. if 'i' is majority element increment count, else decrement count
 * 4. if count is '0', make majority element as current element and count as 1
 * 5. Once we find majority element from the above loop, we have to find if it is actually majority by traversing array one time.
 */
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
