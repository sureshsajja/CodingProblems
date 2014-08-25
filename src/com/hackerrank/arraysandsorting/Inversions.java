package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Inversions
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }
            int[] aux = new int[N];
            System.arraycopy(array, 0, aux, 0, N);
            long inversions = count(array, 0, N - 1, aux);
            pw.println(inversions);
        }
        scanner.close();
        pw.close();
    }

    private static long count(int[] array, int lo, int hi, int[] aux)
    {
        long inversions = 0;
        if (lo >= hi) {
            return 0;
        }

        int mid = lo + ((hi - lo) >> 1);
        inversions += count(array, lo, mid, aux);
        inversions += count(array, mid + 1, hi, aux);
        inversions += merge(array, lo, hi, mid, aux);

        return inversions;
    }

    private static long merge(int[] array, int lo, int hi, int mid, int[] aux)
    {
        long inversions = 0;
        System.arraycopy(array, lo, aux, lo, hi + 1 - lo);

        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > hi) {
                array[k] = aux[i++];
            } else if ((aux[j] < aux[i])) {
                array[k] = aux[j++];
                inversions += (mid - i + 1);
            } else {
                array[k] = aux[i++];
            }
        }
        return inversions;
    }
}
