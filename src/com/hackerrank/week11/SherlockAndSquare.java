package com.hackerrank.week11;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * f(n) = f(n-1)+2^n
 * f(0) = 4
 * f(n) = 2^(n+1)+2
 */
public class SherlockAndSquare
{

    private static final int MOD = 1000000007;


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            pw.println(find(i + 1));
        }

        pw.close();
        scanner.close();
    }

    private static int find(int i)
    {
        long result = 1, a = 2;

        while (i != 0) {
            if ((i & 1) != 0) {
                //if it is odd.. multiply once
                result = (result * a) % MOD;
            }

            i = i >> 1;
            //half the i, and square a
            if (i != 0) {
                a = (a * a) % MOD;
            }
        }

        int r = (int) result + 2;
        return r % MOD;
    }
}
