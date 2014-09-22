package com.geeksforgeeks;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class PossibleTriangles
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

            bruteForce(0, array, 0, new int[3]);

            efficient(array);


        }

        scanner.close();
        pw.close();

    }

    private static void efficient(int[] array)
    {

        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                int k = i + 2;
                while (k < array.length && array[i] + array[j] > array[k])
                    k++;
                count += k - j - 1;
            }
        }

        System.out.println(count);

    }

    private static void bruteForce(int start, int[] array, int K, int[] result)
    {
        if (K == 3) {

            if (result[0] + result[1] > result[2] && result[0] + result[2] > result[1] && result[1] + result[2] > result[0]) {
                for (int i = 0; i < K; i++) {
                    System.out.print(result[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = start; i < array.length; i++) {
            result[K] = array[i];
            bruteForce(i + 1, array, K + 1, result);
        }
    }


}
