package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountingSort1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] hist = new int[100];
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            hist[n]++;
        }

        for (int i : hist) {
            pw.print(i);
            pw.print(" ");
        }

        scanner.close();
        pw.close();
    }
}
