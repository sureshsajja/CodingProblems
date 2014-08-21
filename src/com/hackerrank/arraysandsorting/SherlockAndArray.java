package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndArray
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
            int i = 0;
            int j = N - 1;
            int leftSum = 0;
            int rightSum = 0;
            leftSum += array[i];
            rightSum += array[j];
            while (i <= (j - 2)) {
                if (leftSum < rightSum) {
                    i++;
                    leftSum += array[i];
                }
                if (rightSum < leftSum) {
                    j--;
                    rightSum += array[j];
                }
                if (leftSum == rightSum) {
                    i++;
                    j--;
                    if (i <= j - 2) {
                        leftSum += array[i];
                        rightSum += array[j];
                    }
                }
            }

            i--;
            j++;
            if (j == (i + 2) && leftSum == rightSum) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
        }
        scanner.close();
        pw.close();
    }

}
