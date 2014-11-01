package com.coderevisited.matrix;

/**
 * start from (0,0)
 * if current value is 1. mark it visited
 * Do dfs : recursively visit all '1' which are reachable from this index.
 * For each non visited node, increase island count
 */
public class NumOfIslands
{

    private static final int[] rowNeighbours = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] columnNeighbours = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public static void main(String[] args)
    {
        int N = 5, M = 5;
        int[][] matrix = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};
        int result = CountIslands(matrix, N, M);
        System.out.println("Total number of islands " + result);
    }

    private static int CountIslands(int[][] matrix, int N, int M)
    {
        boolean[][] visited = new boolean[N][M];

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    dfs(matrix, i, j, visited, N, M);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(int[][] matrix, int i, int j, boolean[][] visited, int N, int M)
    {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int row = i + rowNeighbours[k];
            int column = j + columnNeighbours[k];
            if (row >= 0 && row < N && column >= 0 && column < M && !visited[row][column] && matrix[row][column] == 1) {
                dfs(matrix, row, column, visited, N, M);
            }
        }
    }


}
