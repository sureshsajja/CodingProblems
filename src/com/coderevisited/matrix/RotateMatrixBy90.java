package com.coderevisited.matrix;

public class RotateMatrixBy90
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}};
        int N = 3, M = 4;
        int[][] result = rotateMatrix(matrix, N, M);
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrix(int[][] matrix, int N, int M)
    {
        int[][] result = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result[j][N - i - 1] = matrix[i][j];
            }
        }
        return result;
    }
}
