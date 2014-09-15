package com.coderevisited.rmq;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SqrtRMQ
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        double sqrt = Math.sqrt(N);

        int K = (int) Math.round(sqrt);
        int length = (int) Math.ceil(sqrt);
        int[] matrix = new int[length];
        for (int i = 0; i < Math.sqrt(N); i++) {
            int min = i * K;
            for (int j = i * K + 1; (j < (i + 1) * K) && j < N; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            matrix[i] = min;
        }

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int start = A;
            int min;

            if (start % K == 0) {
                if (start + K - 1 <= B)
                    min = matrix[start / K];
                else {
                    min = start;
                }
            } else {
                min = start;
                while (++start % K != 0 && start <= B) {
                    if (array[start] < array[min]) {
                        min = start;
                    }
                }
            }

            while (start + K - 1 <= B) {
                if (array[matrix[start / K]] < array[min]) {
                    min = matrix[start / K];
                }
                start = start + K;
            }


            while (start <= B) {
                if (array[start] < array[min]) {
                    min = start;
                }
                start++;
            }

            pw.println(min);
        }

        scanner.close();
        pw.close();
    }
}
