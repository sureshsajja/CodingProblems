package com.coderevisited.coding.matrix;

public class MaximumSizeSquareSubMatrix
{

    public static void main(String[] args)
    {
        int N = 6, M = 5;
        int[][] matrix = new int[][]{{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        printMaxSizeSquareSubMatrix(matrix, N, M);
    }

    private static void printMaxSizeSquareSubMatrix(int[][] matrix, int N, int M)
    {

        int[][] s = new int[N][M];

        System.arraycopy(matrix[0], 0, s[0], 0, M);

        for (int i = 0; i < N; i++) {
            s[i][0] = matrix[i][0];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == 1) {
                    //top
                    int min = s[i - 1][j];

                    //left
                    if (s[i][j - 1] < min) {
                        min = s[i][j - 1];
                    }

                    //top left corner

                    if (s[i - 1][j - 1] < min) {
                        min = s[i - 1][j - 1];
                    }

                    s[i][j] = min + 1;

                } else {
                    s[i][j] = 0;
                }
            }
        }

        int max = s[0][0], p = 0, q = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (max < s[i][j]) {
                    max = s[i][j];
                    p = i;
                    q = j;
                }
            }
        }

        for (int i = p - max + 1; i <= p; i++) {
            for (int j = q - max + 1; j <= q; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
