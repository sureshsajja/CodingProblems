package com.hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class CounterGame
{
    private static BigInteger one = BigInteger.valueOf(1);
    private static BigInteger zero = BigInteger.valueOf(0);

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        int[] result = new int[T];
        for (int t = 0; t < T; t++) {
            String s = scanner.next();
            BigInteger bin = new BigInteger(s);
            result[t] = findTurns(bin);
        }
        for (int t = 0; t < T; t++) {
            if (isOdd(result[t])) {
                System.out.println("Louise");
            } else {
                System.out.println("Richard");
            }
        }
    }

    private static int findTurns(BigInteger N)
    {
        int result = 0;
        while (!N.equals(one)) {
            result++;
            if (ifPowOfTwo(N)) {
                N = N.shiftRight(1);
            } else {
                N = N.subtract(highestOneBit(N));
            }
        }
        return result;
    }

    public static boolean ifPowOfTwo(BigInteger n)
    {
        BigInteger less = n.subtract(one);
        BigInteger andLess = n.and(less);
        return (andLess).equals(zero);
    }

    public static boolean isOdd(int n)
    {
        return (n & 1) != 0;
    }

    public static BigInteger highestOneBit(BigInteger i)
    {
        i = i.or(i.shiftRight(1));
        i = i.or(i.shiftRight(2));
        i = i.or(i.shiftRight(4));
        i = i.or(i.shiftRight(8));
        i = i.or(i.shiftRight(16));
        i = i.or(i.shiftRight(32));
        return i.subtract(i.shiftRight(1));
    }
}
