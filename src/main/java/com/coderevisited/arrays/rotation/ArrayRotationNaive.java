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

package com.coderevisited.arrays.rotation;

/**
 * array rotation using auxiliary space o(d)
 * time complexity o(1)
 */
public class ArrayRotationNaive
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        rotateArray(array, 4);
        System.out.println("contents after rotation : ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] array, int d)
    {
        int[] temp = new int[d];

        //copy array contents from 0 to d-1 position to a temp array
        System.arraycopy(array, 0, temp, 0, d);

        //move array contents from d to array.length - d -1 position
        System.arraycopy(array, d, array, 0, array.length - d);

        //copy temp array contents from position array.length - d to array.length
        System.arraycopy(temp, 0, array, array.length - d, d);

    }
}
