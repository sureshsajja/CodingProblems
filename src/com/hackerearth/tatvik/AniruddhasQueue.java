package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AniruddhasQueue
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            long sum = 0;
            int lastNonZeroIndex = 0;
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
                if (array[n] > 0) {
                    sum += array[n];
                    lastNonZeroIndex = n;
                }
            }
            long M = scanner.nextLong();
            M = M % sum;
            int index = 0;
            while (M > 0) {
                M -= array[index++];
            }
            long result = index == 0 ? (lastNonZeroIndex + 1) : index;
            pw.println(result);
        }
        scanner.close();
        pw.close();
    }
}
