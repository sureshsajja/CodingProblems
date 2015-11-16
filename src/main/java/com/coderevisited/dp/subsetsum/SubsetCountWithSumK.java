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

package com.coderevisited.dp.subsetsum;

/**
 * Count no of subsets with given sum
 */
public class SubsetCountWithSumK
{
    public static void main(String[] args)
    {
        int[] set = new int[]{7, 10, 11, 12, 4, 5, 6, 3, 2, 1};
        int sum = 8;
        System.out.println(count(set, set.length, sum));
    }

    private static int count(int[] set, int n, int sum)
    {
        int[][] table = new int[sum + 1][n + 1];

        for (int i = 0; i <= sum; i++) {
            table[i][0] = 0;
        }

        for (int j = 0; j <= n; j++) {
            table[0][j] = 1;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                table[i][j] = table[i][j - 1];
                if (i >= set[j - 1]) {
                    table[i][j] += table[i - set[j - 1]][j - 1];
                }
            }
        }
        return table[sum][n];
    }

}
