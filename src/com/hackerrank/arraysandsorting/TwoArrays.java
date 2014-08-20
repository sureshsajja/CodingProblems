package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TwoArrays
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] A = new int[N];
            Integer[] B = new Integer[N];
            for (int i = 0; i < N; i++) {
                A[i] = scanner.nextInt();
            }
            for (int i = 0; i < N; i++) {
                B[i] = scanner.nextInt();
            }

            Arrays.sort(A);
            Arrays.sort(B, Collections.reverseOrder());

            boolean found = true;
            for (int i = 0; i < N; i++) {
                if (A[i] + B[i] < K) {
                    found = false;
                    break;
                }
            }
            if (found) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        scanner.close();
        pw.close();
    }
}
