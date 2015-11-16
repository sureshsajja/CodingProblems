/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.coderevisited.math.utils;

import java.util.Arrays;
import java.util.Collections;

/**
 * http://math.stackexchange.com/a/52478
 */
public class MaximizeXOR
{

    private static int[] mathPow = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384,
            32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864,
            134217728, 268435456, 536870912, 1073741824};

    public static void main(String[] args)
    {
        Integer[] array = new Integer[]{999, 987, 950, 709, 403, 156};
        //Integer[] array = new Integer[]{93163, 44697, 39285, 10941, 7394};
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println(findMaxXOR(array));
    }

    private static int findMaxXOR(Integer[] array)
    {
        if (array.length == 0) {
            return 0;
        }

        int bitPos = 0;

        while (mathPow[bitPos] <= array[0]) {
            bitPos++;
        }

        bitPos--;

        for (int p = bitPos, index = 0; p >= 0; p--) {

            int pow = mathPow[p];
            int k = index;
            while (k < array.length && (array[k] & pow) == 0) {
                k++;
            }
            if (k >= array.length) {
                continue;
            }
            int temp = array[k];
            array[k] = array[index];
            array[index] = temp;

            for (int j = 0; j < array.length; j++) {
                if (j != index && (array[j] & pow) != 0) {
                    array[j] = array[j] ^ array[index];
                }
            }
            index++;
        }
        int result = 0;
        for (Integer anArray : array) {
            result = result ^ anArray;
        }
        return result;

    }

}
