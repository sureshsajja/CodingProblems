package com.coderevisited.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class KthSmallest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[] array = new int[]{6, 7, 8, 9, 10, 11, 1, 2, 3, 4, 0};

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            findKthSmallest(array, 0, array.length - 1, n - 1);
            pw.println(array[n - 1]);
        }

        scanner.close();
        pw.close();
    }


    private static void findKthSmallest(int[] ar, int lo, int hi, int index)
    {

        if (hi <= lo) {
            return;
        }

        int pivot = partition(ar, lo, hi);
        if (pivot == index)
            return;

        if (pivot > index) {
            findKthSmallest(ar, lo, pivot - 1, index);
        } else if (pivot < index) {
            findKthSmallest(ar, pivot + 1, hi, index);
        }

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
