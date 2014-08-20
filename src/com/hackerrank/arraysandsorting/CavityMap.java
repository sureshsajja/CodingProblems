package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CavityMap
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[][] array = new int[N][N];
        for (int n = 0; n < N; n++) {
            String s = scanner.next();
            String[] sArray = s.split("");
            for (int i = 1; i < sArray.length; i++) {
                array[n][i - 1] = Integer.valueOf(sArray[i]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == N - 1) {
                    pw.print(array[i][j]);
                } else {
                    int toCheck = array[i][j];
                    if (toCheck > array[i - 1][j] && toCheck > array[i][j + 1] && toCheck > array[i + 1][j] &&
                            toCheck > array[i][j - 1]) {
                        pw.print("X");
                    } else {
                        pw.print(array[i][j]);
                    }
                }
            }
            pw.println();
        }
        scanner.close();
        pw.close();
    }
}
