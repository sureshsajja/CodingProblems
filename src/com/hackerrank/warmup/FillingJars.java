package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class FillingJars
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long N = scanner.nextLong();
        long M = scanner.nextLong();
        long total = 0;
        for (int m = 0; m < M; m++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long k = scanner.nextLong();
            total += (b + 1 - a) * k;
        }

        pw.println(total / N);
        pw.close();
        scanner.close();
    }
}
