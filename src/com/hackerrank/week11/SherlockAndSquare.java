package com.hackerrank.week11;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * f(n) = f(n-1)+2^n
 * f(0) = 4
 * f(n) = 2^(n+1)+2
 */
public class SherlockAndSquare
{


    private static BigInteger two = BigInteger.valueOf(2L);
    private static BigInteger mod = BigInteger.valueOf(1000000007);


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            pw.println(find(i));
        }

        pw.close();
        scanner.close();
    }

    private static int find(int i)
    {
        return two.pow(i + 1).add(two).mod(mod).intValue();
    }

}
