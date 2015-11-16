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

/**
 * Run two loops, i start from 0 to n-2, j start from i+1 to n-1
 * Assume sub array starts at i and ends at j.
 * for each iteration, update min and max in the sub array
 * If max - min == j - i, that is the sub array with contiguous elements. Update maxLength
 */
public class LargestSubArrayContiguous
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
        int length = findMaxLengthSubArray(array);
        System.out.println("Size Largest sub Array With contiguous elements " + length);
    }

    private static int findMaxLengthSubArray(int[] array)
    {

        int maxLength = 1;

        for (int i = 0; i < array.length - 1; i++) {

            int min = array[i];
            int max = array[i];

            for (int j = i + 1; j < array.length; j++) {

                if (min > array[j]) {
                    min = array[j];
                }
                if (max < array[j]) {
                    max = array[j];
                }

                if (max - min == j - i) {
                    if (j - i > maxLength)
                        maxLength = j - i + 1;
                }
            }
        }

        return maxLength;
    }
}
