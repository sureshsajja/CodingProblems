package com.hackerrank.warmup;

import java.util.Scanner;

public class ChocolateFeast
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long N = scanner.nextLong();
            long C = scanner.nextLong();
            long M = scanner.nextLong();

            long canBeBought = N / C;

            long quotient = canBeBought / M;
            long reminder = canBeBought % M;
            canBeBought += quotient;
            while (quotient != 0) {
                long wrappers = quotient + reminder;
                quotient = wrappers / M;
                reminder = wrappers % M;
                canBeBought += quotient;

            }
            System.out.println(canBeBought);

        }
    }
}
