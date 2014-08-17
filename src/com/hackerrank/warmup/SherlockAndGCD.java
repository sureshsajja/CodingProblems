package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndGCD
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int gcd = scanner.nextInt();
            for (int i = 1; i < n; i++) {
                int b = scanner.nextInt();
                if (gcd != 1) {
                    if (gcd > b)
                        gcd = GCD(gcd, b);
                    else
                        gcd = GCD(b, gcd);
                }
            }

            if (gcd == 1)
                pw.println("YES");
            else {
                pw.println("NO");
            }

        }

        scanner.close();
        pw.close();

    }

    private static int GCD(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

}
