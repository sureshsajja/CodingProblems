package com.hackerrank;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class NecklaceBruteForce
{
    private static int MAX = 10000;
    private static int[][] matrix = new int[MAX + 1][MAX + 1];
    private static int MOD = 1000000000 + 7;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            pw.println(count(i));
        }

        pw.close();
        scanner.close();
    }

    private static long count(int i)
    {
        long result = 1;
        for (int n = i, k = 1; n >= k; n -= 2, k++) {
            int r = k;
            if (k > n / 2) {
                r = n - k;
            }
            if (matrix[n][r] == 0) {
                calculateValue(n, r);
            }
            result = (result + matrix[n][r]) % MOD;
        }
        return result;
    }

    private static long calculateValue(int n, int k)
    {

        if (matrix[n][k] != 0) {
            return matrix[n][k];
        }

        for (int i = 0; i <= n; i++) {
            if (matrix[i][k] == 0) {
                for (int j = 0; j <= k; j++) {
                    if (matrix[i][j] == 0) {
                        if (j == 0 || i == 0 || i == j) {
                            matrix[i][j] = 1;
                        } else {
                            matrix[i][j] = (int) (matrix[i - 1][j - 1] + (long) matrix[i - 1][j]) % MOD;
                        }
                    }
                }
            }
        }
        return matrix[n][k];
    }
}
