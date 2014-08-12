
package com.coderevisited.utils;

import java.util.Arrays;
import java.util.Collections;

public class MaximizeXOR
{

    public static void main(String[] args)
    {
        Integer[] array = new Integer[]{};

        Arrays.sort(array, Collections.reverseOrder());

        int result = 0;
        if (array.length > 0) {
            int firstPos = Integer.numberOfLeadingZeros(array[0]);

            for (int i = 0; i < array.length; i++) {

                if (!ifNthBitSet(array[i], 31 - firstPos - i)) {
                    for (int k = i + 1; k < array.length; k++) {
                        if (ifNthBitSet(array[k], 31 - firstPos - i)) {
                            int temp = array[k];
                            array[k] = array[i];
                            array[i] = temp;
                            break;
                        }
                    }
                }
                int pow = (int) Math.pow(2, 31 - firstPos - i);
                for (int j = i + 1; j < array.length && array[j] >= pow; j++) {
                    array[j] = array[j] ^ array[i];
                }
            }


            for (Integer anArray : array) {
                int tempResult = result ^ anArray;
                result = result > tempResult ? result : tempResult;
            }
        }
        System.out.println(result);
    }

    private static boolean ifNthBitSet(int A, int N)
    {
        return (A & (1 << N)) != 0;
    }

}
