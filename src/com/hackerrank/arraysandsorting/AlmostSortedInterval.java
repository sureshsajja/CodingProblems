package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

//This is for sorted interval.... TODO
public class AlmostSortedInterval
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
        long count = 0;
        for (int i = 0; i < N; i++) {
            count++;
            int prev = array[i];
            for (int j = i + 1; j < N; j++) {
                if (array[j] < prev) {
                    break;
                }
                prev = array[j];
                count++;
            }
        }

        pw.println(count);
        scanner.close();
        pw.close();
    }

}
