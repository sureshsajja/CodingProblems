package com.hackerrank;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//TODO optimise this
public class Necklace
{
    private static int MAX = 1000;
    private static long[][] matrix = new long[MAX + 1][MAX + 1];
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
