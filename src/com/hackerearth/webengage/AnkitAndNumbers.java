package com.hackerearth.webengage;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AnkitAndNumbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long l = (long) Math.pow(2, 41);
        pw.println(l);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();

            long result = 0L;
            for (int i = 0; i < N; i++) {
                long times = (long) Math.pow(2, N - 1);
                result += times * (i + 1);
            }

            pw.println(result);

        }

        scanner.close();
        pw.close();
    }
}
