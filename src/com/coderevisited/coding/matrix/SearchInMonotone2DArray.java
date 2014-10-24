package com.coderevisited.coding.matrix;

public class SearchInMonotone2DArray
{
    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}};

        int[] result = findElement(matrix, 4, 30);
        if (result != null) {
            System.out.println("position of the key : (" + result[0] + "," + result[1] + ")");
        } else {
            System.out.println("key not found");
        }
    }

    private static int[] findElement(int[][] matrix, int n, int key)
    {
        int i = 0, j = n - 1;
        while (j >= 0 && i < n) {
            if (matrix[i][j] == key) {
                return new int[]{i, j};
            } else if (matrix[i][j] > key) {
                j--;
            } else
                i++;
        }

        return null;
    }

}

