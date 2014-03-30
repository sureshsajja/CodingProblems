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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        int[] cycles = new int[60];

        cycles[0] = 1;
        for (int i = 1; i < 60; i++) {
            if (i % 2 == 0) {
                cycles[i] = cycles[i - 1] + 1;
            } else
                cycles[i] = cycles[i - 1] * 2;
        }

        for (int i = 0; i < K; i++) {
            System.out.println(cycles[scanner.nextInt()]);
        }
    }
}
