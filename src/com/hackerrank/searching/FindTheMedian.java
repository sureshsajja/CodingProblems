package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindTheMedian
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        findMedian(array, 0, N - 1, (N - 1) / 2);

        pw.println(array[(N - 1) / 2]);

        scanner.close();
        pw.close();
    }


    private static void findMedian(int[] ar, int lo, int hi, int median)
    {

        if (hi <= lo) {
            return;
        }

        int pivot = partition(ar, lo, hi);
        if (pivot == median)
            return;

        if (pivot > median) {
            findMedian(ar, lo, pivot - 1, median);
        } else if (pivot < median) {
            findMedian(ar, pivot + 1, hi, median);
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
