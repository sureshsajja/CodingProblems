package com.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GameOfStrengths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            Integer[] array = new Integer[N];
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }

            long MOD = 1000000007L;
            Arrays.sort(array, Collections.reverseOrder());
            long sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum = (sum + (N - 1 - i) * array[i] - (N - 1 - i) * array[N - 1 - i]) % MOD;
            }
            sum = (sum * array[0]) % MOD;
            System.out.println(sum);
        }
    }
}
