package com.hackerearth.target;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AtoB
{
    private static final long MOD = 1000000007L;
    private static final BigInteger prime = BigInteger.valueOf(MOD);

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        long[] A = new long[N + 1];
        long prod = 1L;
        Set<Integer> zeroIndexes = new HashSet<Integer>();
        for (int n = 1; n <= N; n++) {
            A[n] = scanner.nextLong();
            if (A[n] != 0) {
                prod = (prod * A[n]) % MOD;
            } else {
                zeroIndexes.add(n);
            }
        }

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int type = scanner.nextInt();
            if (type == 0) {
                int index = scanner.nextInt();
                long V = scanner.nextLong();
                if (zeroIndexes.contains(index)) {
                    zeroIndexes.remove(index);
                } else {
                    long inverse = modInverse(A[index]);
                    prod = (prod * inverse) % MOD;
                }
                A[index] = V;
                if (V != 0) {
                    prod = (prod * V) % MOD;
                } else {
                    zeroIndexes.add(index);
                }

            } else if (type == 1) {
                int index = scanner.nextInt();
                if (zeroIndexes.size() > 1) {
                    pw.println(0);
                } else if (zeroIndexes.size() == 1) {
                    if (zeroIndexes.contains(index)) {
                        pw.println(prod);
                    } else {
                        pw.println(0);
                    }
                } else {
                    long inverse = modInverse(A[index]);
                    long val = (prod * inverse) % MOD;
                    pw.println(val);
                }
            }
        }

        scanner.close();
        pw.close();

    }

    public static long modInverse(long value)
    {
        return BigInteger.valueOf(value).modInverse(prime).longValue();
    }
}
