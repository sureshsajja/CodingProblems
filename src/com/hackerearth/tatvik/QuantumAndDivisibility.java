package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

//TODO testing
public class QuantumAndDivisibility
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            long c = scanner.nextLong();
            long d = scanner.nextLong();

            BigInteger bigA = BigInteger.valueOf(a);
            BigInteger bigB = BigInteger.valueOf(b);
            BigInteger bigC = BigInteger.valueOf(c);
            BigInteger bigD = BigInteger.valueOf(d);

            BigInteger one = raiseMtoPower(bigA, bigB, bigA);
            BigInteger two = raiseMtoPower(bigC, bigD, bigC);

            if (one.remainder(two).equals(BigInteger.ZERO))
                pw.println("Divisible");
            else
                pw.println("Not divisible");

        }

        scanner.close();
        pw.close();
    }

    private static BigInteger raiseMtoPower(BigInteger m, BigInteger k, BigInteger f)
    {
        if (k.equals(BigInteger.ZERO) || k.equals(BigInteger.ONE) || k.compareTo(BigInteger.ZERO) == -1) {
            return m;
        }

        m = raiseMtoPower(m, k.shiftRight(1), f);
        m = m.multiply(m);

        if ((k.and(BigInteger.ONE)).equals(BigInteger.ONE)) {
            m = m.multiply(f);
        }
        return m;
    }
}
