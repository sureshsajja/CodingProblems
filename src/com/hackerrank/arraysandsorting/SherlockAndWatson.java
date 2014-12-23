package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndWatson
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int Q = scanner.nextInt();

        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[(n + K) % N] = scanner.nextInt();
        }

        for (int q = 0; q < Q; q++) {
            int i = scanner.nextInt();
            pw.println(array[i]);
        }


        scanner.close();
        pw.close();

    }
}
