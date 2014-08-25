package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndMiniMax
{

    private static int N;
    private static int[] array;
    private static int P;
    private static int Q;
    private static int answer;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        N = scanner.nextInt();
        array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        P = scanner.nextInt();
        Q = scanner.nextInt();

        answer = P;
        limits(P);
        limits(Q);

        for (int i = 0; i < N; ++i) {
            for (int j = i + 1; j < N; ++j) {
                limits((array[i] + array[j]) / 2);
            }
        }

        pw.println(answer);

        scanner.close();
        pw.close();
    }


    private static int check(int x)
    {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < N; ++i)
            ret = ret > Math.abs(x - array[i]) ? Math.abs(x - array[i]) : ret;
        return ret;
    }

    private static void limits(int x)
    {
        if (x < P || x > Q) return;
        if (check(x) > check(answer)) answer = x;
    }


}
