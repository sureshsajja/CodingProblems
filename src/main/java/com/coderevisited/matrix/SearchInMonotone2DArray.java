/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.coderevisited.matrix;

/**
 * Algorithm:
 * =========
 * Start from top right corner element.
 * If element is equal to the key, return
 * if element > key, reduce column
 * if element < key, increase row
 * repeat until, search is with in matrix boundaries.
 */
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

