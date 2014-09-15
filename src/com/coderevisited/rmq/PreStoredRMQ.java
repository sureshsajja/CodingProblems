package com.coderevisited.rmq;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PreStoredRMQ
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            matrix[i][i] = i;
            for (int j = i + 1; j < N; j++) {
                if (array[matrix[i][j - 1]] < array[j]) {
                    matrix[i][j] = matrix[i][j - 1];
                } else {
                    matrix[i][j] = j;
                }
            }
        }

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            pw.println(matrix[A][B]);
        }

        scanner.close();
        pw.close();
    }
}
