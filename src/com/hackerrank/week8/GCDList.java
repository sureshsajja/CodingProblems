package com.hackerrank.week8;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class GCDList
{

    private static final PrintWriter writer;

    static {
        writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)), true);
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int n = 0; n < N; n++) {
                A[n] = scanner.nextInt();
            }
            findMinGCDList(A);
        }
    }

    private static void findMinGCDList(int[] A)
    {
        int[] B = new int[A.length + 1];
        B[B.length - 1] = A[A.length - 1];
        for (int i = B.length - 2; i > 0; i--) {
            B[i] = lcm(A[i], A[i - 1]);
        }
        B[0] = A[0];

        for (int b : B) {
            writer.print(b);
            writer.print(" ");
        }
        writer.println();

    }

    private static int lcm(int a, int b)
    {
        return a * (b / GCD(a, b));
    }

    public static int GCD(int a, int b)
    {
        if (b == 0) {
            return a;
        }
        return GCD(b, a % b);
    }

}
