package com.coderevisited.matrix;

/**
 * In the first iteration find sum of sub matrix of size K x 1
 * In the second iteration find sum of sub square matrix K x K
 *
 */
public class SumOfAllSubSquares
{
    public static void main(String[] args)
    {
//        int N = 5;
//        int[][] matrix = new int[][]{{1, 1, 1, 1, 1},
//                {2, 2, 2, 2, 2},
//                {3, 3, 3, 3, 3},
//                {4, 4, 4, 4, 4},
//                {5, 5, 5, 5, 5},
//        };
//        int K = 3;

        int N = 3, K = 2;
        int[][] matrix = new int[][]{{1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
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

        int[][] stripSum = new int[k][n];

        for (int j = 0; j < n; j++) {
            int i = 0;
            while (i < n - k + 1) {
                for (int p = i; p < i + k; p++) {
                    stripSum[i][j] += matrix[p][j];
                }
                i++;
            }
        }

        int[][] sum = new int[k][k];
        for (int i = 0; i < k; i++) {
            int j = 0;
            while (j < n - k + 1) {

                for (int p = j; p < j + k; p++) {
                    sum[i][j] += stripSum[i][p];
                }
                j++;
            }
        }

        return sum;


    }
}
