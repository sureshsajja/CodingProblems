package com.coderevisited.subsetsum;

public class SubsetSumRecursive
{
    public static void main(String[] args)
    {
        int[] set = new int[]{7, 10, 11, 12, 4, 5, 6, 10, 11};
        int sum = 9;
        System.out.println(exists(set, set.length - 1, sum));
    }

    private static boolean exists(int[] set, int n, int sum)
    {
        if (sum == 0) {
            return true;
        } else if (n == 0) {
            return false;
        }

        if (set[n] > sum) {
            return exists(set, n - 1, sum);
        }

        return exists(set, n - 1, sum) || exists(set, n - 1, sum - set[n]);
    }

}
