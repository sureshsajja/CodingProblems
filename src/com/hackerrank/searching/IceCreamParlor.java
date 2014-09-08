package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class IceCreamParlor
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int[] array = new int[N];

            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (array[i] + array[j] == M) {
                        pw.println((i + 1) + " " + (j + 1));
                        break;
                    }
                }
            }
        }
        scanner.close();
        pw.close();
    }
}
