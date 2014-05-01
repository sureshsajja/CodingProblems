package com.hackerearth;

import java.util.Arrays;
import java.util.Scanner;

public class Comrades {

    private static final int MAX = 100000;
    private static int[] array = new int[MAX];
    private static int[] height = new int[MAX];
    private static int length;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            length = scanner.nextInt();
            Arrays.fill(height, -1);
            Arrays.fill(array, -1);
            for (int j = 0; j < length; j++) {
                int k = scanner.nextInt();
                array[j] = k - 1;
            }
            find();
        }
    }

    private static void find() {
        long sumOfHeights = 0;
        for (int i = 0; i < length; i++) {
            sumOfHeights += findHeight(i);
        }
        long fistBumps = ((long) (length) * (length - 1) / 2) - sumOfHeights;
        System.out.println(sumOfHeights + " " + fistBumps);
    }

    private static int findHeight(int i) {


        if (height[i] != -1) {
            return height[i];
        }

        if (array[i] == -1)
            return 0;

        if (i != array[i]) {
            height[i] = 1 + findHeight(array[i]);
            return height[i];
        }

        return 0;


    }
}
