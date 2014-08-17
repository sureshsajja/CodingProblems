package com.hackerearth.augustclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * 1. Numbers from N to 2*N-1
 * 2. First N primes
 * 3. Output whose sum is less.
 */

public class Xperiment
{

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            for (int i = 0; i < N; i++) {
                pw.print(i + N);
                pw.print(" ");
            }
            pw.println();
        }

        scanner.close();
        pw.close();
    }


}

