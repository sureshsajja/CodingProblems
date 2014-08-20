package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuickSort1Partition
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
        partition(ar);
        for (int i : ar) {
            pw.print(i);
            pw.print(" ");
        }
        pw.println();
        scanner.close();
        pw.close();
    }

    private static void partition(int[] ar)
    {
        List<Integer> l1 = new ArrayList<Integer>();
        List<Integer> l2 = new ArrayList<Integer>();
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] < ar[0]) {
                l1.add(ar[i]);
            } else {
                l2.add(ar[i]);
            }
        }

        int pivot = ar[0];
        int i = 0;
        for (int n : l1) {
            ar[i++] = n;
        }
        ar[i++] = pivot;
        for (int n : l2) {
            ar[i++] = n;
        }
    }

}
