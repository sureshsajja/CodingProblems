package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class MarkAndToys
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int k = scanner.nextInt();

        int[] toys = new int[N];

        for (int n = 0; n < N; n++) {
            toys[n] = scanner.nextInt();
        }

        Arrays.sort(toys);

        int totalPrice = 0;
        int num_toys = 0;
        while (totalPrice + toys[num_toys] <= k && num_toys < N) {
            totalPrice += toys[num_toys++];
        }

        pw.println(num_toys);
        scanner.close();
        pw.close();
    }
}
