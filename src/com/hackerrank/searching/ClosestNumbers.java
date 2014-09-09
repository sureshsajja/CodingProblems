package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ClosestNumbers
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

        Arrays.sort(array);
        int[] diff = new int[N - 1];

        int min = Integer.MAX_VALUE;
        for (int n = N - 1; n > 0; n--) {
            diff[n - 1] = array[n] - array[n - 1];
            min = min < diff[n - 1] ? min : diff[n - 1];
        }

        for (int n = 0; n < N - 1; n++) {
            if (diff[n] == min) {
                pw.print(array[n] + " " + array[n + 1] + " ");
            }
        }

        scanner.close();
        pw.close();
    }
}
