package com.hackerearth.septemberclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class LittleMontyAndFibonacci
{

    private static BigInteger[] fibNumber = new BigInteger[1001];
    private static int[] multipleSum = new int[1001];

    static {
        fibNumber[0] = BigInteger.ONE;
        fibNumber[1] = BigInteger.ONE;

        multipleSum[0] = 1;
        multipleSum[1] = 4;
        multipleSum[2] = 7;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        fib(1000);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            pw.println(multiple(N - 1));
        }

        scanner.close();
        pw.close();
    }

    private static BigInteger fib(int i)
    {

        if (fibNumber[i] != null) {
            return fibNumber[i];
        } else {
            return fibNumber[i] = fib(i - 1).add(fib(i - 2));
        }

    }

    private static int multiple(int n)
    {
        if (multipleSum[n] != 0)
            return multipleSum[n];
        else {

            int present = 0;
            BigInteger bigInt = fibNumber[n];
            for (int m = 0; m <= n; m++) {
                if (bigInt.remainder(fibNumber[m]).equals(BigInteger.ZERO)) {
                    present++;
                }
            }

            return multipleSum[n] = present + multiple(n - 1);
        }
    }
}
