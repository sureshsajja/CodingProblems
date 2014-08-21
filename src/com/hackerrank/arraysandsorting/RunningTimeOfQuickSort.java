package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunningTimeOfQuickSort
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scanner.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = scanner.nextInt();
        }
        int[] copy = new int[n];
        System.arraycopy(ar, 0, copy, 0, n);
        int quickMoves = quickSort(ar);
        int insertionSortMoves = insertionSort(copy);
        pw.println(insertionSortMoves - quickMoves);

        scanner.close();
        pw.close();
    }

    private static int insertionSort(int[] array)
    {
        int numMoves = 0;
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
                numMoves++;
            }
            array[j + 1] = current;
        }
        return numMoves;
    }

    private static int quickSort(int[] ar)
    {
        int[] swaps = new int[1];
        sort(ar, 0, ar.length - 1, swaps);
        return swaps[0];
    }

    private static void sort(int[] ar, int lo, int hi, int[] swaps)
    {
        if (hi <= lo) {
            return;
        }
        int pivot = partition(ar, lo, hi, swaps);

        if (lo != pivot && lo != pivot - 1) {
            sort(ar, lo, pivot - 1, swaps);
        }

        if (hi != pivot && hi != pivot + 1) {
            sort(ar, pivot + 1, hi, swaps);
        }
    }

    private static int partition(int[] ar, int lo, int hi, int[] swaps)
    {
        int pivot = ar[hi];
        int moves = 0;
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= pivot) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
                moves++;
            }
        }
        int temp = ar[i + 1];
        ar[i + 1] = ar[hi];
        ar[hi] = temp;
        moves++;
        swaps[0] += moves;
        return i + 1;
    }

}
