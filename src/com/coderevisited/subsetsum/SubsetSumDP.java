package com.coderevisited.subsetsum;

/**
 * Checks if there exists any subset with given sum
 */
public class SubsetSumDP
{

    public static void main(String[] args)
    {
        int[] set = new int[]{10, 11, 12, 4, 1};
        int sum = 5;
        System.out.println(exists(set, set.length, sum));
    }

    private static boolean exists(int[] set, int n, int sum)
    {
        boolean[][] table = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= sum; i++) {
            table[i][0] = false;
        }

        for (int j = 0; j <= n; j++) {
            table[0][j] = true;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (i >= set[j - 1]) {
                    table[i][j] = table[i][j] || table[i - set[j - 1]][j - 1];
                }
            }
        }
        return table[sum][n];
    }

}
