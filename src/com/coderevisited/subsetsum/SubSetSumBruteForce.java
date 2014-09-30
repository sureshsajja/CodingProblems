package com.coderevisited.subsetsum;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class SubSetSumBruteForce
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] set = new int[]{-624, -915, 397, 452, 870, -658, 362, 590, 952, 44, 645, 54, -326, 376, 856, -983, 170,
                -874, 503, 915, -847, -982, 999, 475, -880, 756, 183, -266, 423, -745, 813};
        int sum = 0;
        long start = System.nanoTime();
        printSubsets(0, set, sum, new int[set.length], 0, 0, pw);
        pw.println((double) (System.nanoTime() - start) / 1000000000.0);
        pw.close();
    }

    private static void printSubsets(int start, int[] set, int sum, int[] result, int currentSum, int index,
                                     PrintWriter pw)
    {
        if (currentSum == sum && index > 0) {
            for (int i = 0; i < index; i++) {
                pw.print(result[i] + " ");
            }
            pw.println();
        } else {
            for (int i = start; i < set.length; i++) {
                result[index] = set[i];
                printSubsets(i + 1, set, sum, result, currentSum + set[i], index + 1, pw);
            }
        }
    }
}
