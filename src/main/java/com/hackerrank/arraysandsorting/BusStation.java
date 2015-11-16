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

package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BusStation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        int sum = 0;
        int max = 0;
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
            sum += array[n];
            max = max > array[n] ? max : array[n];
        }

        Set<Integer> set = new TreeSet<Integer>();
        set.add(sum);

        for (int i = 2; (sum / i) >= max; i++) {
            if ((sum % i) == 0) {
                int presentSum = sum / i;
                int count = 0;
                for (int j = 0; j < N; j++) {
                    count += array[j];
                    if (count == presentSum) {
                        count = 0;
                    }
                    if (count > presentSum) {
                        break;
                    }
                }
                if (count == 0) {
                    set.add(presentSum);
                }
            }
        }

        for (Integer i : set) {
            pw.print(i);
            pw.print(" ");
        }


        scanner.close();
        pw.close();

    }
}
