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

package com.hackerrank.warmup;

import java.util.Scanner;

/**
 * The Utopian tree goes through 2 cycles of growth every year. The first growth cycle of the tree is during the monsoon
 * season when it doubles in height. The second growth cycle is during the summer when it increases in height by 1
 * meter. If a new Utopian tree sapling of height 1 meter is planted just before the onset of the monsoon season, can
 * you find the height of the tree after N cycles?
 * <p/>
 * input: 2 0 1
 * <p/>
 * output: 1 2
 */

public class UtopianTree
{

    private static int[] cycles = new int[10000];

    static {
        for (int i = 0; i < cycles.length; i++) {
            cycles[i] = -1;
        }
    }


    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();

        for (int i = 0; i < K; i++) {
            System.out.println(getLengthAfterNCycles(scanner.nextInt()));
        }
    }

    private static int getLengthAfterNCycles(int N)
    {

        if (N == 0) {
            cycles[N] = 1;
        }

        if (cycles[N] != -1) {
            return cycles[N];
        }

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
