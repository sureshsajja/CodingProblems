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

package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort
{
    private static Scanner scanner = new Scanner(System.in);
    private static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args)
    {

        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        quickSort(ar);
        for (int i : ar) {
            pw.print(i);
            pw.print(" ");
        }
        pw.println();
        scanner.close();
        pw.close();

    }

    private static void quickSort(int[] ar)
    {
        sort(ar, 0, ar.length - 1);
    }

    private static void sort(int[] ar, int lo, int hi)
    {

        if (hi <= lo)
            return;
        int pivot = partition(ar, lo, hi);

        if (lo != pivot && lo != pivot - 1) {
            sort(ar, lo, pivot - 1);
            printSubArray(ar, lo, pivot - 1);
        }

        if (hi != pivot && hi != pivot + 1) {
            sort(ar, pivot + 1, hi);
            printSubArray(ar, pivot + 1, hi);
        }
    }

    static void printSubArray(int[] ar, int lo, int hi)
    {
        for (int i = lo; i <= hi; i++) {
            pw.print(ar[i]);
            pw.print(" ");
        }
        pw.println();
    }

    private static int partition(int[] ar, int lo, int hi)
    {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = lo + 1; i <= hi; i++) {
            if (ar[i] < ar[lo]) {
                l1.add(ar[i]);
            } else {
                l2.add(ar[i]);
            }
        }

        int pivot = ar[lo];
        int i = lo;
        for (int n : l1) {
            ar[i++] = n;
        }
        int toReturn = i;
        ar[i++] = pivot;
        for (int n : l2) {
            ar[i++] = n;
        }

        return toReturn;
    }
}
