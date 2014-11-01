package com.coderevisited.matrix;

/**
 * Given an n x n square matrix, find sum of all sub-squares of size k x k where k is smaller than or equal to n.
 */
public class SumOfAllSubSquaresNaive
{

    public static void main(String[] args)
    {
        int N = 5;
        int[][] matrix = new int[][]{{1, 1, 1, 1, 1},
                {2, 2, 2, 2, 2},
                {3, 3, 3, 3, 3},
                {4, 4, 4, 4, 4},
                {5, 5, 5, 5, 5},
        };
        int K = 3;
        int[][] sum = getSumMatrix(matrix, N, K);
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] getSumMatrix(int[][] matrix, int n, int k)
    {
        int[][] sum = new int[k][k];
        for (int i = 0; i < n - k + 1; i++) {
            for (int j = 0; j < n - k + 1; j++) {

                for (int p = i; p < k + i; p++) {
                    for (int q = j; q < k + j; q++) {
                        sum[p - i][q - j] += matrix[p][q];
                    }
                }

            }
        }
        return sum;
    }
}
