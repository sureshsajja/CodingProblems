package com.hackerrank.warmup;


import java.util.Scanner;

public class ServiceLane
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int T = scanner.nextInt();
        int[] width = new int[length];
        for (int l = 0; l < length; l++) {
            width[l] = scanner.nextInt();
        }

        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int min = 3;

            for (int k = i; k <= j; k++) {
                if (width[k] < min) {
                    min = width[k];
                }
            }
            System.out.println(min);
        }
    }

}
