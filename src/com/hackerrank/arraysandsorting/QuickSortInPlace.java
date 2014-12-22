package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuickSortInPlace
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        sort(array, 0, n - 1, pw);

        scanner.close();
        pw.close();

    }


    private static void sort(int[] ar, int lo, int hi, PrintWriter pw)
    {
        if (hi <= lo) {
            return;
        }
        int pivot = partition(ar, lo, hi);

        printArray(ar, pw);

        if (lo != pivot && lo != pivot - 1) {
            sort(ar, lo, pivot - 1, pw);
        }

        if (hi != pivot && hi != pivot + 1) {
            sort(ar, pivot + 1, hi, pw);
        }
    }

    private static void printArray(int[] ar, PrintWriter pw)
    {
        for (int i : ar) {
            pw.print(i + " ");
        }
        pw.println();
    }


    private static int partition(int[] ar, int lo, int hi)
    {
        int pivot = ar[hi];
        int i = lo - 1;
        for (int j = lo; j < hi; j++) {
            if (ar[j] <= pivot) {
                i++;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;

            }
        }
        int temp = ar[i + 1];
        ar[i + 1] = ar[hi];
        ar[hi] = temp;
        return i + 1;
    }
}
