package com.coderevisited.coding.matrix;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class MatrixDiagonal
{
    public static void main(String[] args)
    {
        int N = 5;
        int M = 6;
        int[][] matrix = new int[][]{{1, 2, 3, 4, 21, 26},
                {5, 6, 7, 8, 22, 27},
                {9, 10, 11, 12, 23, 28},
                {13, 14, 15, 16, 24, 29},
                {17, 18, 19, 20, 25, 30}};

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        for (int i = 0; i < N; i++) {
            for (int j = 0, k = i; j <= i && j < M; j++, k--) {
                pw.print(matrix[k][j] + " ");
            }
            pw.println();
        }

        for (int j = 1; j < M; j++) {
            for (int i = N - 1, k = j; i >= 0 && k < M; i--, k++) {
                pw.print(matrix[i][k] + " ");
            }
            pw.println();
        }
        pw.println();

        pw.close();
    }
}
