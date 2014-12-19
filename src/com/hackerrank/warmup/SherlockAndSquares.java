package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SherlockAndSquares
{

    private static NavigableSet<Integer> perfectSquares = new TreeSet<>();

    static {
        for (int i = 1; i <= 31623; i++) {
            perfectSquares.add(i * i);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            pw.println(perfectSquares.subSet(A, true, B, true).size());
        }

        scanner.close();
        pw.close();

    }
}
