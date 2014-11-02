package com.coderevisited.arrays;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 1. start from 0 to array.length -1;
 * 2. find first out of place element, i.e either positive at even index or negative at odd index
 * 3. find position of correct element, replace out of place element with correct element and shift array
 * 4. now out of place element will be 2 positions head
 */
public class RearrangePositivesAndNegative
{
    public static void main(String[] args)
    {

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int[] array = new int[]{-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
        rearrange(array);
        printArray(array, pw);
        pw.close();

    }

    private static void rearrange(int[] array)
    {
        int outOfPlace = -1;
        for (int i = 0; i < array.length; i++) {

            if (outOfPlace >= 0) {
                if (array[i] >= 0 && array[outOfPlace] < 0 || array[i] < 0 && array[outOfPlace] >= 0) {
                    rightRotate(array, outOfPlace, i);
                    if (i - outOfPlace > 2)
                        outOfPlace = outOfPlace + 2;
                    else
                        outOfPlace = -1;
                }
            }

            if (outOfPlace == -1) {
                if (array[i] >= 0 && ((i & 1) != 1) || array[i] < 0 && ((i & 1) == 1))
                    outOfPlace = i;
            }
        }

    }

    private static void rightRotate(int[] array, int i, int j)
    {
        int temp = array[j];
        System.arraycopy(array, i, array, i + 1, j - i);
        array[i] = temp;
    }

    private static void printArray(int[] array, PrintWriter pw)
    {
        for (int i : array) {
            pw.print(i + " ");
        }
        pw.println();
    }
}
