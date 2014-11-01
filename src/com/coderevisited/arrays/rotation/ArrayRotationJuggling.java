package com.coderevisited.arrays.rotation;

import com.coderevisited.math.utils.MathUtils;

/**
 * http://www.cs.bell-labs.com/cm/cs/pearls/s02b.pdf
 */
public class ArrayRotationJuggling
{
    public static void main(String[] args)
    {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        rotateArray(array, 4);
        System.out.println("contents after rotation : ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    private static void rotateArray(int[] array, int d)
    {
        int gcd = MathUtils.gcd(array.length, d);

        for (int i = 0; i < gcd; i++) {
            int pivot = array[i];
            int j = i;
            int k;
            while (true) {
                k = j + d;
                if (k >= array.length)
                    k = k - array.length;
                if (k == i)
                    break;
                array[j] = array[k];
                j = k;
            }
            array[j] = pivot;
        }

    }
}
