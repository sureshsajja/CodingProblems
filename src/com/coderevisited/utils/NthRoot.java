package com.coderevisited.utils;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class NthRoot
{
    public static double nthroot(int n, double x)
    {
        return nthroot(n, x, .0001);
    }

    public static double nthroot(int n, double x, double p)
    {
        double x1 = x;
        double x2 = x / n;
        while (Math.abs(x1 - x2) > p) {
            x1 = x2;
            x2 = ((n - 1.0) * x2 + x / Math.pow(x2, n - 1.0)) / n;
        }
        return x2;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = scanner.nextInt();
        int x = scanner.nextInt();
        double root = nthroot(n, x);
        pw.println(root);

        pw.close();
        scanner.close();
    }

}

