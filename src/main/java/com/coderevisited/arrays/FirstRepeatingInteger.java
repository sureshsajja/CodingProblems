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

package com.coderevisited.arrays;

import com.coderevisited.searching.DuplicateCount;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Using hashing:
 * =============
 * Start from N - 1 to 0, at each position
 * if element is in Hash set, update index
 * else add element to set
 * return index
 * <p/>
 * using binary search :
 * ===================
 * 1. Create tempArray with array contents and sort the temp Array
 * 2. for each element in the array, do a binary search on temp array to count number of occurrences.
 * 3. If count is more than one return that index
 */
public class FirstRepeatingInteger
{
    public static void main(String[] args)
    {
        int[] array = new int[]{6, 10, 5, 4, 9, 120, 4, 6, 10};
        int index = findRepeatingIndex(array);
        System.out.println("Index of first repeated integer " + index + " and element is " + array[index]);


        index = findRepeatingIndexBinarySearch(array);
        if (index != -1)
            System.out.println("Index of first repeated integer " + index + " and element is " + array[index]);
        else {
            System.out.println("No repeated integer");
        }

    }

    private static int findRepeatingIndexBinarySearch(int[] array)
    {
        int[] temp = new int[array.length];
        System.arraycopy(array, 0, temp, 0, array.length);

        Arrays.sort(temp);

        for (int i = 0; i < array.length; i++) {
            int min = DuplicateCount.leastIndexBinarySearch(temp, 0, temp.length - 1, array[i]);
            int max = DuplicateCount.maxIndexBinarySearch(temp, 0, temp.length - 1, array[i]);
            if (max - min != 0) {
                return i;
            }
        }

        return -1;
    }

    private static int findRepeatingIndex(int[] array)
    {
        HashSet<Integer> set = new HashSet<>();
        int index = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (set.contains(array[i])) {
                index = i;
            } else {
                set.add(array[i]);
            }
        }

        return index;
    }
}
