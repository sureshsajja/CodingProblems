package com.hackerrank.warmup;

import java.util.Scanner;

public class MaxXORBruteForce
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int result = 0;
        for (int i = A; i <= B; i++) {
            for (int j = i + 1; j <= B; j++) {
                if (i != j) {
                    result = (result > (i ^ j)) ? result : (i ^ j);
                }
            }
        }

        System.out.println(result);

    }
}
