package com.hackerearth.octobereasy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class StartingGameDevelopment
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();

        int[][] strengths = new int[N + 1][M + 1];

        for (int n = 1; n <= N; n++) {
            for (int m = 1; m <= M; m++) {
                strengths[n][m] = scanner.nextInt();
            }
        }

        for (int q = 0; q < Q; q++) {
            int minLevel = M;
            for (int n = 1; n <= N; n++) {
                int s = scanner.nextInt();
                int level = maxIndexBinarySearch(strengths[n], 0, M, s);
                minLevel = minLevel < level ? minLevel : level;
            }
            pw.println(minLevel);
        }
        scanner.close();
        pw.close();
    }

    private static int maxIndexBinarySearch(int[] array, int low, int high, int key)
    {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((array[mid] == key) && (mid == array.length - 1 || array[mid + 1] > key)) {
                return mid;
            } else if (array[mid] > key) {
                high = mid - 1;
            } else
                low = mid + 1;
        }

        return high;
    }
}
