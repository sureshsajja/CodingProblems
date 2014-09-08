package com.hackerrank.week9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LexicographicPaths
{

    private static int[] next_perm = new int[2097152];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int M = scanner.nextInt();
            int N = scanner.nextInt();
            int K = scanner.nextInt();

            int V = 0;
            for (int n = 0; n < N; n++) {
                V += Math.pow(2, n);
            }

            int ans = findKthPerm(V, K);

            String s = String.format("%" + (M + N) + "s", Integer.toBinaryString(ans)).replace(' ', '0');
            s = s.replace('0', 'H');
            s = s.replace('1', 'V');
            pw.println(s);
        }
        pw.close();
        scanner.close();
    }

    private static int findKthPerm(int V, int K)
    {
        while (K > 0) {
            V = next_perm(V);
            K--;
        }
        return V;
    }

    private static int next_perm(int v)
    {
        if (next_perm[v] == 0) {
            int t = (v | (v - 1)) + 1;
            next_perm[v] = t | ((((t & -t) / (v & -v)) >> 1) - 1);
        }
        return next_perm[v];
    }


}
