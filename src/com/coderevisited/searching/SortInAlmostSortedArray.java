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

public class SortInAlmostSortedArray
{
    public static void main(String[] args)
    {
        int[] array = new int[]{10, 3, 40, 20, 50, 80, 70};

        for (int i : array) {
            int index = searchInArray(array, i);
            if (index != -1)
                System.out.println("key " + (i) + " found at index : " + index);
            else
                System.out.println("key " + (i) + " not found");
        }
    }

    private static int searchInArray(int[] array, int key)
    {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key)
                return mid;
            else if (mid > 0 && array[mid - 1] == key)
                return mid - 1;
            else if (mid <= array.length - 1 && array[mid + 1] == key)
                return mid + 1;
            else if (array[mid] > key)
                high = mid - 2;
            else if (array[mid] < key)
                low = mid + 2;
            else return -1;
        }
        return -1;
    }
}
