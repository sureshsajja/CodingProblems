package com.hackerrank;

import java.util.Scanner;

//TODO optimise this
public class Necklace
{
    private static int MAX = 10000;
    private static long[][] matrix = new long[MAX + 1][MAX + 1];
    private static int MOD = 1000000000 + 7;

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            System.out.println(count(i));
        }

    }

    private static long count(int i)
    {
        long result = 1;
        for (int n = i, k = 1; n >= k; n -= 2, k++) {
            if (matrix[n][k] == 0)
                calculateValue(n, k);
            result = (result + matrix[n][k]) % MOD;
        }
        return result;
    }

    private static long calculateValue(int n, int k)
    {

        if (matrix[n][k] != 0)
            return matrix[n][k];

        if (k == 0 || n == 0 || n == k) {
            matrix[n][k] = 1;
            return 1;
        }

        matrix[n - 1][k - 1] = calculateValue(n - 1, k - 1);
        matrix[n - 1][k] = calculateValue(n - 1, k);

        matrix[n][k] = (matrix[n - 1][k - 1] + matrix[n - 1][k]) % MOD;
        return matrix[n][k];


    }
}
