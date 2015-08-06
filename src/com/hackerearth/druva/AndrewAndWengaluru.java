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

package com.hackerearth.druva;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AndrewAndWengaluru
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }
            pw.println(findWaterCollected(array));
        }

        scanner.close();
        pw.close();
    }


    private static int findWaterCollected(int[] array)
    {

        if (array.length < 3)
            return 0;

        long count = 0;
        int maxLeft = 0;
        int k = 1;
        int maxRight = 2;
        while (maxLeft < array.length && k < array.length && maxRight < array.length) {
            for (int i = maxRight + 1; i < array.length; i++) {
                if (array[i] > array[maxRight]) {
                    maxRight = i;
                }
            }

            while (k < maxRight) {
                if (array[k] < array[maxLeft] && array[k] < array[maxRight]) {
                    int min = array[maxLeft] < array[maxRight] ? array[maxLeft] : array[maxRight];
                    count = (count + min - array[k]) % 1000000007;
                }
                if (array[k] > array[maxLeft]) {
                    maxLeft = k;
                }
                k++;
            }
            maxLeft = maxRight;
            k = maxLeft + 1;
            maxRight = maxLeft + 2;
        }

        return (int) count;

    }
}
