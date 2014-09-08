package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Flowers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Integer[] array = new Integer[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }
        Arrays.sort(array, Collections.reverseOrder());

        int totalCost = 0;


        for (int n = 0; n < N; n++) {
            totalCost += array[n] * (n / K + 1);
        }

        pw.println(totalCost);
        scanner.close();
        pw.close();
    }
}
