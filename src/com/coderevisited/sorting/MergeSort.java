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
