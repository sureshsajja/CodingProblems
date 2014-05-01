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
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
            System.out.println(height[i]);
        }
        long fistBumps = ((long) (length) * (length - 1) / 2) - sumOfHeights;
        System.out.println(sumOfHeights + " " + fistBumps);
    }

    private static int findHeight(int i) {

        if (i < 0)
            return 0;

        if (height[i] != -1) {
            return height[i];
        }

        if (array[i] == -1) {
            if (height[i] == -1) {
                height[i] = 0;
            }
            return 0;
        }

        if (i != array[i]) {
            int n = array[i];
            array[i] = -1;
            height[i] = 1 + findHeight(n);
            return height[i];
        }

        return 0;


    }
}
