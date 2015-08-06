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

package com.coderevisited.rmq;

import com.coderevisited.math.utils.MathUtils;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
 */
public class SegmentTreeRMQ
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        int logN = (int) MathUtils.log(N, 2);
        int pow = (int) Math.pow(2, logN + 1);
        int K = 2 * pow;
        int[] matrix = new int[K];

        init(0, 0, N - 1, matrix, array);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            pw.println(query(0, 0, N - 1, matrix, array, A, B));
        }

        scanner.close();
        pw.close();
    }

    private static int query(int index, int b, int e, int[] matrix, int[] array, int A, int B)
    {
        if (A > e || B < b) {
            return -1;
        }

        if (b >= A && e <= B) {
            return matrix[index];
        }

        int p1 = query(2 * index + 1, b, (b + e) / 2, matrix, array, A, B);
        int p2 = query(2 * index + 2, (b + e) / 2 + 1, e, matrix, array, A, B);

        if (p1 == -1) {
            return p2;
        }
        if (p2 == -1) {
            return p1;
        }
        if (array[p1] <= array[p2]) {
            return p1;
        }
        return p2;
    }

    private static void init(int index, int i, int j, int[] matrix, int[] array)
    {
        if (i == j) {
            matrix[index] = i;
        } else {
            init(2 * index + 1, i, (i + j) / 2, matrix, array);
            init(2 * index + 2, (i + j) / 2 + 1, j, matrix, array);

            if (array[matrix[2 * index + 1]] < array[matrix[2 * index + 2]]) {
                matrix[index] = matrix[2 * index + 1];
            } else {
                matrix[index] = matrix[2 * index + 2];
            }
        }
    }
}
