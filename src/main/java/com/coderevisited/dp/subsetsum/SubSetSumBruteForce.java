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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Print all subsets with given sum
 */
public class SubSetSumBruteForce
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] set = new int[]{-624, -915, 397, 452, 870, -658, 362, 590, 952, 44, 645, 54, -326, 376, 856, -983, 170,
                -874, 503, 915, -847, -982, 999, 475, -880, 756, 183, -266, 423, -745, 813};
        int sum = 0;
        long start = System.nanoTime();
        printSubsets(0, set, sum, new int[set.length], 0, 0, pw);
        pw.println((double) (System.nanoTime() - start) / 1000000000.0);
        pw.close();
    }

    private static void printSubsets(int start, int[] set, int sum, int[] result, int currentSum, int index,
                                     PrintWriter pw)
    {
        if (currentSum == sum && index > 0) {
            for (int i = 0; i < index; i++) {
                pw.print(result[i] + " ");
            }
            pw.println();
        } else {
            for (int i = start; i < set.length; i++) {
                result[index] = set[i];
                printSubsets(i + 1, set, sum, result, currentSum + set[i], index + 1, pw);
            }
        }
    }
}
