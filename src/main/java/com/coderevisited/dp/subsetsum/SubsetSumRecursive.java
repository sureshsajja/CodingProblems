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
 * Recursively checks if there exists any subset with given sum
 */
public class SubsetSumRecursive
{
    public static void main(String[] args)
    {
        int[] set = new int[]{7, 10, 11, 12, 4, 5, 6, 10, 11, -15};
        int sum = 0;
        System.out.println(exists(set, set.length, sum));
    }

    private static boolean exists(int[] set, int n, int sum)
    {
        if (sum == 0 && n != set.length - 1) {
            return true;
        } else if (n == 0) {
            return false;
        }

        if (set[n - 1] > sum) {
            return exists(set, n - 1, sum);
        }

        return exists(set, n - 1, sum) || exists(set, n - 1, sum - set[n - 1]);
    }

}
