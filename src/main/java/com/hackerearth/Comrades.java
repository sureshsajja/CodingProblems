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

package com.hackerearth;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * It’s the year 2552, the Humans just won a war against a very powerful alien race that had invaded our solar system.
 * The Human army is in celebration mode! The army has n soldiers. The soldiers are numbers from 1 to n. The army has a
 * superiority hierarchy. Every soldier has one immediate superior. The superior of a superior of a soldier is also a
 * superior to that soldier. So, a soldier may have one or more superiors but only one immediate superior. Every soldier
 * has to congratulate every other soldier. For a pair of soldiers if one of them is the superior of the other, they
 * will shake hands. Otherwise, they will bump their fists. You are given the list of immediate superior of all
 * soldiers. Your job is to tell how many handshakes and fist bumps will be there.
 * NOTE: Among all soldiers there is one
 * soldier who does not have any superior. He is the commander of the whole army.
 * Input:
 * The first line of the input contains t, the number of test cases.
 * The first line of each test case contains n, the number of soldiers.
 * The next line contains n space separated integers. The ith integer represents the immediate superior of the ith soldier. The
 * immediate superior of the commander of the army will be '0'.
 * Output:
 * Output two space separated integers, the number
 * of handshakes and the number of fist bumps.
 * Constraints:
 * 1<=t<=10 1<=n<=100000
 * It is guaranteed that the commander of the army is a superior of all soldiers.
 */
public class Comrades
{

    private static final int MAX = 100000;
    private static int[] array = new int[MAX];
    private static int[] height = new int[MAX];
    private static int length;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            length = scanner.nextInt();
            Arrays.fill(height, -1);
            Arrays.fill(array, -1);
            for (int j = 0; j < length; j++) {
                int k = scanner.nextInt();
                if (k == 0) {
                    height[j] = 0;
                }
                array[j] = k - 1;
            }
            find();
        }
    }

    private static void find()
    {
        long sumOfHeights = 0;
        for (int i = 0; i < length; i++) {
            sumOfHeights += findHeight(i);
        }
        long fistBumps = ((long) (length) * (length - 1) / 2) - sumOfHeights;
        System.out.println(sumOfHeights + " " + fistBumps);
    }

    private static int findHeight(int i)
    {

        Stack<Integer> stack = new Stack<Integer>();
        int index = i;
        int h = height[i];
        while (h == -1) {
            stack.push(i);
            i = array[i];
            h = height[i];
        }

        while (!stack.isEmpty()) {
            int k = stack.pop();
            height[k] = ++h;
        }

        return height[index];
    }
}
