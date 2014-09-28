package com.hackerearth.septemberrush;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.BitSet;
import java.util.Scanner;

public class MastermindBirthdayParty
{

    private static int MAX = 1000000;
    private static BitSet bitSet = new BitSet(MAX);
    private static int[] matrix = new int[1000001];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        sieve();
        matrix[1] = 1;

        for (int i = 2; i <= MAX; i++) {
            matrix[i] = matrix[i - 1] + (isDivisibleByN(i) ? 1 : 0);
        }

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int L = scanner.nextInt();
            int R = scanner.nextInt();
            pw.println(matrix[R] - matrix[L - 1]);
        }

        scanner.close();
        pw.close();
    }


    private static void sieve()
    {
        for (int i = 3; i < Math.sqrt(MAX); i += 2) {
            if (!bitSet.get(i)) {
                for (int j = i * i; j < MAX; j += i) {
                    bitSet.set(j);
                }
            }
        }
    }

    private static boolean isDivisibleByN(int i)
    {
        return i != 4 && !isPrime(i);
    }

    private static boolean isPrime(int i)
    {
        if (i == 2)
            return true;
        if ((i & 1) == 1) {
            if (!bitSet.get(i)) {
                return true;
            }
        }

        return false;
    }


}
