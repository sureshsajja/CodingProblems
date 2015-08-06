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

package com.coderevisited.sorting;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MergeSort
{
    private static final int MIN_SIZE = 7;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        int[] aux = new int[N];
        System.arraycopy(array, 0, aux, 0, N);
        mergeSort(array, 0, N - 1, aux);

        for (int i = 0; i < N; i++) {
            pw.print(array[i]);
            pw.print(" ");
        }
        pw.println();

        scanner.close();
        pw.close();

    }

    private static void mergeSort(int[] array, int lo, int hi, int[] aux)
    {
        if (lo + MIN_SIZE >= hi) {
            insertionSort(array, lo, hi);
            return;
        }

        int mid = lo + ((hi - lo) >> 1);
        mergeSort(aux, lo, mid, array);
        mergeSort(aux, mid + 1, hi, array);


        if (array[mid + 1] >= array[mid]) {
            System.arraycopy(array, lo, aux, lo, hi - lo + 1);
            return;
        }

        merge(array, lo, hi, mid, aux);


    }

    private static void insertionSort(int[] array, int lo, int hi)
    {
        for (int i = lo; i <= hi; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    private static void merge(int[] array, int lo, int hi, int mid, int[] aux)
    {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if ((aux[j] < aux[i])) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }
}
