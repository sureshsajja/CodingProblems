package com.coderevisited.subsetsum;

/**
 * Count no of subsets with given sum
 */
public class SubsetCountWithSumK
{
    public static void main(String[] args)
    {
        int[] set = new int[]{7, 10, 11, 12, 4, 5, 6, 3, 2, 1};
        int sum = 8;
        System.out.println(count(set, set.length, sum));
    }

    private static int count(int[] set, int n, int sum)
    {
        int[][] table = new int[sum + 1][n + 1];

        for (int i = 0; i <= sum; i++) {
            table[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            table[0][j] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (i >= set[j - 1]) {
                    table[i][j] += table[i - set[j - 1]][j - 1];
                }
            }
        }
        return table[sum][n];
    }

}
