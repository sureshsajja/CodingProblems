package com.hackerearth.octobereasy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GirlfriendsDemands
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String s = scanner.next();
        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            int A = (int) (a % s.length());
            if (A == 0)
                A = s.length();
            int B = (int) (b % s.length());
            if (B == 0)
                B = s.length();

            char c1 = s.charAt(A - 1);
            char c2 = s.charAt(B - 1);
            if (c1 == c2) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }

        }

        scanner.close();
        pw.close();

    }
}
