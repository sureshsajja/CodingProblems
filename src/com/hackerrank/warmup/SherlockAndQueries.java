package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndQueries
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] A = new int[N];
        int[] B = new int[M];
        int[] C = new int[M];

        for (int n = 0; n < N; n++) {
            A[n] = scanner.nextInt();
        }

        for (int m = 0; m < M; m++) {
            B[m] = scanner.nextInt();
        }

        for (int m = 0; m < M; m++) {
            C[m] = scanner.nextInt();
        }


        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if ((j % B[i]) == 0) {
                    A[j - 1] = (int) ((A[j - 1] * (long) C[i]) % 1000000007);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            pw.print(A[i]);
            pw.print(" ");
        }


        scanner.close();
        pw.close();
    }
}
