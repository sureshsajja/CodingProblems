package com.hackerrank.week9;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SansaAndXOR
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {

            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }

            int result = 0;
            for (int i = 0; i < N; i++) {
                int times = (N - i) * (i + 1);
                if ((times & 1) == 1) {
                    result = result ^ array[i];
                }
            }
            pw.println(result);
        }


        scanner.close();
        pw.close();
    }
}
