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

package com.coderevisited.arrays.sum;

import com.coderevisited.searching.BinarySearch;

import java.util.Arrays;

/**
 * Find Triplet
 * 1. Sort the given array
 * 2. for each element 'i' from 0 to array.length - 3
 * 3. find if there exists any pair whose sum is equal to 'SUM - array[i]'
 * <p/>
 * To find all pairs
 * ================
 * for each element 'i' from 0 to array.length - 3
 * for each element 'j' from i+1, to array.length - 2
 * find there exists any element 'k' whose value is 'SUM - array[i]-array[k]
 */
public class ThreeSum
{
    public static void main(String[] args)
    {
        int[] array = new int[]{12, 3, 4, 1, 6, 9, 20, 7, 16};
        findTriplet(array, 24);
        System.out.println("Now finding all pairs ..");
        findAllTriplet(array, 24);
    }

    private static void findTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int j = i + 1;
            int k = array.length - 1;

            while (j < k) {
                if (array[i] + array[j] + array[k] == sum) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[j] + ", " + array[k]);
                    return;
                } else if (array[i] + array[j] + array[k] > sum) {
                    k--;
                } else if (array[i] + array[j] + array[k] < sum) {
                    j++;
                }
            }
        }
    }

    private static void findAllTriplet(int[] array, int sum)
    {
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                int k = BinarySearch.binarySearch(array, j + 1, array.length - 1, sum - array[j] - array[i]);
                if (k > 0) {
                    System.out.println("values that make the given sum :  " + array[i] + ", " + array[j] + ", " + array[k]);
                }
            }
        }
    }
}
