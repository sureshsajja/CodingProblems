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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Replace with Next greatest element
 * 1. Start from array.length -1 to 0
 * 2. For each iteration, Keep track of the maximum. set current element to max.
 * 3. Finally set last element to -1
 */
public class ReplaceWithNextGreatest
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[] array = new int[]{16, 6, 9, 10, 11, 17, 4, 3, 9, 8, 5, 2, 14};
        replaceWithNextGreatest(array);
        printArray(array, pw);

        array = new int[]{-2, -7, -8};
        replaceWithNextGreatest(array);
        printArray(array, pw);

        pw.close();
    }

    private static void replaceWithNextGreatest(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            array[i] = max;
            max = max > current ? max : current;
        }
        //set N-1th element to -1
        array[array.length - 1] = -1;
    }

    private static void printArray(int[] array, PrintWriter pw)
    {
        for (int i : array) {
            pw.print(i + " ");
        }
        pw.println();
    }
}
