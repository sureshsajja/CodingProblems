package com.hackerearth.augustclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Xperiment
{
    private static final int MAX = 50000;
    private static int[] primes = new int[MAX];

    public static void main(String[] args)
    {


        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            sieve(N);
            for (int i = 0; i < N; i++) {
                pw.print(primes[i]);
                pw.print(" ");
            }
            pw.println();
        }

        scanner.close();
        pw.close();
    }

    private static void sieve(int N)
    {

        boolean[] vector = new boolean[MAX];

        for (int i = N; i < MAX; i++) {
            if (!vector[i]) {
                for (int j = i + i; j < MAX; j = j + i) {
                    vector[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = N; i < MAX; i++) {
            if (!vector[i])
                primes[count++] = i;
        }

    }

}

