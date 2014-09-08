package com.hackerrank.week9;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;


public class MixingProteins
{

    private static int[][] matrix = new int[][]{{0, 1, 2, 3}, {1, 0, 3, 2}, {2, 3, 0, 1},
            {3, 2, 1, 0}};


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        char[] chars = scanner.next().toCharArray();

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = chars[i] - 'A';
        }

        int first = array[0];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N - 1; j++) {
                array[j] = matrix[array[j]][array[j + 1]];
            }
            array[N - 1] = matrix[array[N - 1]][first];
            first = array[0];

        }

        for (int k = 0; k < N; k++) {
            char c = (char) (array[k] + 'A');
            pw.print(c);
        }
        pw.println();


        scanner.close();
        pw.close();
    }
}
