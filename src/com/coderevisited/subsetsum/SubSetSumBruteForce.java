package com.coderevisited.subsetsum;

public class SubSetSumBruteForce
{
    public static void main(String[] args)
    {
        int[] set = new int[]{3, 10, 11, 12, 4, 5, 6, 10, 11, 3, 3, -3};
        int sum = 0;
        printSubsets(0, set, sum, new int[set.length], 0, 0);
    }

    private static void printSubsets(int start, int[] set, int sum, int[] result, int currentSum, int index)
    {
        if (currentSum == sum && index > 0) {
            for (int i = 0; i < index; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = start; i < set.length; i++) {
                result[index] = set[i];
                printSubsets(i + 1, set, sum, result, currentSum + set[i], index + 1);
            }
        }
    }
}
