package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IsFibo
{

    private static List<Long> fibs = new ArrayList<Long>();

    static {
        fibs.add(0L);
        fibs.add(1L);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long n = scanner.nextLong();
            if (isFib(n))
                pw.println("IsFibo");
            else {
                pw.println("IsNotFibo");
            }
        }

        scanner.close();
        pw.close();
    }

    private static boolean isFib(long n)
    {
        findFibUpToN(n);
        return fibs.contains(n);

    }

    private static void findFibUpToN(long n)
    {
        if (fibs.get(fibs.size() - 1) > n)
            return;

        while (fibs.get(fibs.size() - 1) < n) {
            fibs.add(fibs.get(fibs.size() - 2) + fibs.get(fibs.size() - 1));
        }

    }


}
