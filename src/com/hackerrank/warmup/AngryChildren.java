package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class AngryChildren
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        Arrays.sort(array);


        int diff = array[K - 1] - array[0];
        for (int i = 1, j = K; j < N; j++, i++) {
            diff = diff < (array[j] - array[i]) ? diff : (array[j] - array[i]);
        }

        pw.println(diff);

        scanner.close();
        pw.close();
    }
}
