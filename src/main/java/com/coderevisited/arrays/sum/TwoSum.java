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
import java.util.HashSet;
import java.util.Set;

/**
 * 2-SUM problem
 * Check if any pair exists :
 * 1. Sort the array
 * 2. Use two pointers, low points to first element, high points to last elements
 * 3. if(array[low]+array[high] == SUM) return low, high
 * 4. if(array[low]+array[high] > SUM) decrement high;
 * 5. if(array[low]+array[high] < SUM) increment low;
 * 6. Repeat 3,4,5 until low < high
 * <p/>
 * <p/>
 * <p/>
 * Find all pairs :
 * Approach 1:
 * ===========
 * 1. Sort the array
 * 2. For each element i, using binary search find if there exists sum - i. return pair
 * <p/>
 * Approach 2:
 * ===========
 * For each element 'i' in the array, construct HashSet progressively.
 * At each step, check if there is 'sum - i' exists in the hash set. return i, sum - i.
 */
public class TwoSum
{

    public static void main(String[] args)
    {

        //distinct integers
        int[] array = new int[]{1, 4, 45, 6, 10, -8};
        int[] result = findTwoSum(array, 16);
        if (result != null) {
            System.out.println("values that make the given sum : " + result[0] + " and " + result[1]);
        }

        findAllPairs(array, 16);

        findAllPairsByHashing(array, 16);

    }

    private static void findAllPairsByHashing(int[] array, int sum)
    {
        Set<Integer> set = new HashSet<>(array.length);
        for (int i : array) {
            if (set.contains(sum - i)) {
                System.out.println("values that make the given sum : " + i + " and " + (sum - i));
            }
            set.add(i);
        }

    }

    public static int[] findTwoSum(int[] array, int sum)
    {
        Arrays.sort(array);

        int low = 0, high = array.length - 1;

        while (low < high) {
            if (array[low] + array[high] == sum) {
                return new int[]{array[low], array[high]};
            } else if (array[low] + array[high] > sum) {
                high--;
            } else if (array[low] + array[high] < sum) {
                low++;
            }
        }

        return null;
    }

    public static void findAllPairs(int[] array, int sum)
    {
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            int toFind = sum - array[i];
            int returned = BinarySearch.binarySearch(array, i + 1, array.length - 1, toFind);
            if (returned > 0) {
                System.out.println("values that make the given sum :  " + array[i] + " , " + array[returned]);
            }
        }

    }

}
