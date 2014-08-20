package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class InsertionSortPart1
{

    private static Scanner scanner = new Scanner(System.in);
    private static PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args)
    {
        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        insertionSort(array);

        for (int i = 0; i < N; i++) {
            pw.print(array[i]);
            pw.print(" ");
        }

        scanner.close();
        pw.close();
    }

    private static void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && current < array[j]) {
                array[j + 1] = array[j];
                j--;
                printArray(array);
            }
            array[j + 1] = current;
        }
    }

    private static void printArray(int[] array)
    {
        for (int i : array) {
            pw.print(i);
            pw.print(" ");
        }
        pw.println();
    }
}

