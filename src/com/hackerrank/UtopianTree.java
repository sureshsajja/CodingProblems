package com.hackerrank;

import java.util.Scanner;

/**
 * The Utopian tree goes through 2 cycles of growth every year.
 * The first growth cycle of the tree is during the monsoon season when it doubles in height.
 * The second growth cycle is during the summer when it increases in height by 1 meter.
 * If a new Utopian tree sapling of height 1 meter is planted just before the onset of the monsoon season,
 * can you find the height of the tree after N cycles?
 * <p/>
 * input:
 * 2
 * 0
 * 1
 * <p/>
 * output:
 * 1
 * 2
 */

public class UtopianTree {

    private static int[] cycles = new int[10000];

    static {
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = -1;
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            System.out.println(getLengthAfterNCycles(scanner.nextInt()));
        }
    }

    private static int getLengthAfterNCycles(int N) {

        if (N == 0) {
            cycles[N] = 1;
        }

        if (cycles[N] != -1)
            return cycles[N];

        int prev = getLengthAfterNCycles(N - 1);

        if (N % 2 == 0) {
            cycles[N] = prev + 1;
            return cycles[N];
        } else {
            cycles[N] = prev * 2;
            return cycles[N];
        }


    }
}
