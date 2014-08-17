package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ManasaAndStones
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            Set<Integer> result = new TreeSet<Integer>();
            for (int i = n - 1; i >= 0; i--) {
                result.add(a * i + b * (n - 1 - i));
            }

            for (int r : result) {
                pw.print(r);
                pw.print(" ");
            }
            pw.println();
        }
        scanner.close();
        pw.close();

    }

}
