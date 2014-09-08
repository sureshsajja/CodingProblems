package com.hackerrank.searching;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LonelyInteger
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int nonRepeat = 0;
        for (int n = 0; n < N; n++) {
            nonRepeat ^= scanner.nextInt();
        }

        pw.println(nonRepeat);

        scanner.close();
        pw.close();

    }
}
