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

package com.coderevisited.searching;

public class RotatedArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4};
        //int[] array = new int[]{5, 6, 1, 2, 3, 4};
        // int[] array = new int[]{1, 0, 2, 3, 4};
        //int[] array = new int[]{2, 1};
        // int[] array = new int[]{1};
        //int[] array = new int[]{1, 2};
        //int[] array = new int[]{5, 6, 7, 1, 2, 3, 4};
        // int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        // int[] array = new int[]{2, 3, 4, 5, 6, 7, 8, 1};
        //  int[] array = new int[]{3, 4, 5, 1, 2};
        // int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2};
        //int[] array = new int[]{2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2};
        // int[] array = new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1};
        // int[] array = new int[]{3, 3, 3, 4, 4, 4, 4, 5, 3, 3};
        // int[] array = new int[]{1, 1, 2, 2, 3};
        //  int[] array = new int[]{1, 1, 0, 1};

        int min = findMin(array, 0, array.length - 1);
        int a = -1;
        if (min > 0) {
            a = binarySearch(array, 0, min - 1, 4);
        }
        if (a == -1)
            a = binarySearch(array, min, array.length - 1, 4);

        System.out.println(a);

    }

    private static int findMin(int[] array, int low, int high)
    {
        if (low < high) {
            int mid = low + (high - low) / 2;

            if (mid > low && array[mid] < array[mid - 1]) {
                return mid;
            }
            if (mid < high && array[mid + 1] < array[mid])
                return mid + 1;

            if (array[high] > array[mid]) {
                return findMin(array, low, mid - 1);
            } else if (array[high] < array[mid])
                return findMin(array, mid + 1, high);
            else {
                int a = findMin(array, mid + 1, high);
                int b = findMin(array, low, mid - 1);
                if (array[a] < array[b])
                    return a;
                else
                    return b;
            }
        }
        return low;
    }

    private static int binarySearch(int[] array, int low, int high, int key)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key)
                return mid;
            else if (array[mid] > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;

    }
}
