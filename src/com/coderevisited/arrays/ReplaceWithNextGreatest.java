package com.coderevisited.arrays;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Replace with Next greatest element
 * 1. Start from array.length -1 to 0
 * 2. For each iteration, Keep track of the maximum. set current element to max.
 * 3. Finally set last element to -1
 */
public class ReplaceWithNextGreatest
{
    public static void main(String[] args)
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int[] array = new int[]{16, 6, 9, 10, 11, 17, 4, 3, 9, 8, 5, 2, 14};
        replaceWithNextGreatest(array);
        printArray(array, pw);

        array = new int[]{-2, -7, -8};
        replaceWithNextGreatest(array);
        printArray(array, pw);

        pw.close();
    }

    private static void replaceWithNextGreatest(int[] array)
    {
        int max = Integer.MIN_VALUE;
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            array[i] = max;
            max = max > current ? max : current;
        }
        //set N-1th element to -1
        array[array.length - 1] = -1;
    }

    private static void printArray(int[] array, PrintWriter pw)
    {
        for (int i : array) {
            pw.print(i + " ");
        }
        pw.println();
    }
}
