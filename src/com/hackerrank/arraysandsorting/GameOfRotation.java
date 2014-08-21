package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GameOfRotation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        long[] array = new long[N];
        long sum = 0;
        long pMean = 0;
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextLong();
            sum += array[n];
            pMean += (n + 1) * array[n];
        }

        long maxPMean = pMean;
        for (int i = 1; i < N; i++) {
            pMean = pMean - sum + (N) * array[i - 1];
            maxPMean = maxPMean > pMean ? maxPMean : pMean;
        }

        pw.println(maxPMean);

        scanner.close();
        pw.close();
    }
}
