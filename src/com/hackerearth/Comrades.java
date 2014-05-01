package com.hackerearth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

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
                if (k == 0)
                    height[j] = 0;
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

        Stack<Integer> stack = new Stack<Integer>();
        int index = i;
        int h = height[i];
        while (h == -1) {
            stack.push(i);
            i = array[i];
            h = height[i];
        }

        while (!stack.isEmpty()) {
            int k = stack.pop();
            height[k] = ++h;
        }

        return height[index];
    }
}
