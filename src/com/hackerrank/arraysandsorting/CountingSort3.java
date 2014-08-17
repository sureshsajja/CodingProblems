package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CountingSort3
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] hist = new int[100];
        String[] aux = new String[N];
        for (int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            aux[i] = scanner.next();
            hist[n]++;
        }

        int result = 0;
        for (int i : hist) {
            result += i;
            pw.print(result);
            pw.print(" ");
        }

        scanner.close();
        pw.close();
    }
}
