package com.hackerrank.warmup;

import java.util.Scanner;

public class HalloweenParty
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int n = 0; n < N; n++) {
            long i = scanner.nextLong();
            long half = i >> 1;
            long result = half * (i - half);
            System.out.println(result);
        }
    }
}
