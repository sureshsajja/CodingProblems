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
 * Initialize A = arr[0..d-1] and B = arr[d..n-1]
 * 1) Do following until size of A is equal to size of B
 * <p/>
 * a)  If A is shorter, divide B into Bl and Br such that Br is of same
 * length as A. Swap A and Br to change ABlBr into BrBlA. Now A
 * is at its final place, so recur on pieces of B.
 * <p/>
 * b)  If A is longer, divide A into Al and Ar such that Al is of same
 * length as B Swap Al and B to change AlArB into BArAl. Now B
 * is at its final place, so recur on pieces of A.
 * <p/>
 * 2)  Finally when A and B are of equal size, block swap them.
 */

public class ArrayRotationBlockSwap
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotateArray(array, 4);
        System.out.println("contents after rotation : ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] array, int d)
    {

        int i, j;
        if (d == 0 || d == array.length)
            return;
        i = d;
        j = array.length - d;
        while (i != j) {
             /*A is shorter*/
            if (i < j) {
                swap(array, d - i, d + j - i, i);
                j -= i;
            } else {
                /*B is shorter*/
                swap(array, d - i, d, j);
                i -= j;
            }
        }
        /*Finally, block swap A and B*/
        swap(array, d - i, d, i);

    }


    private static void swap(int array[], int i, int j, int d)
    {
        int k, temp;
        for (k = 0; k < d; k++) {
            temp = array[i + k];
            array[i + k] = array[j + k];
            array[j + k] = temp;
        }
    }
}
