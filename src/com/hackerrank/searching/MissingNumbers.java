package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class MissingNumbers
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] A = new int[N];
        for (int n = 0; n < N; n++) {
            A[n] = scanner.nextInt();
        }

        Arrays.sort(A);

        int M = scanner.nextInt();
        int[] B = new int[M];
        for (int m = 0; m < M; m++) {
            B[m] = scanner.nextInt();
        }

        Arrays.sort(B);

        int n = 0, m = 0;
        Set<Integer> result = new TreeSet<Integer>();
        while (m < M) {
            if (n < N && A[n] == B[m]) {
                n++;
                m++;
            } else {
                result.add(B[m]);
                m++;
            }
        }

        for (Integer i : result) {
            pw.print(i + " ");
        }

        pw.println();

        scanner.close();
        pw.close();
    }
}
