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

/**
 * Author : Suresh
 * Created on : 22/03/15.
 */

/**
 * Roy has a matrix of size NxN. Rows and Columns are numbered from 0 to N-1.
 * jth column of ith row contains i xor j.
 * <p/>
 * In other words, Matrix[i][j] = i ^ j where 0 ≤ i,j < N. ( ^ is a bitwise operation used in C/C++ for xor, please use appropriate symbol if you're using any other language)
 * <p/>
 * Your task is to find the maximum value occurring in this matrix and the count of its occurrence.
 * <p/>
 * Input:
 * First line contains T - number of test cases
 * Following T lines each contains an integer N - size of matrix
 * <p/>
 * Output:
 * For each test case output the maximum value and its count separated by a space in a new line.
 * <p/>
 * Constraints:
 * 1 ≤ T ≤ 100000 (105 )
 * 1 ≤ N ≤ 1000000000000000000 ( 1018 )
 * <p/>
 * Sample Input (Plaintext Link)
 * 2
 * 2
 * 3
 * <p/>
 * Sample Output (Plaintext Link)
 * 1 2
 * 3 2
 * <p/>
 * Explanation
 * For N=2, Matrix will look like:
 * <p/>
 * 0 1
 * 1 0
 * <p/>
 * Maximum value in this matrix is 1 and it occurs 2 times.
 * <p/>
 * For N=3, Matrix will look like:
 * <p/>
 * 0 1 2
 * 1 0 3
 * 2 3 0
 * <p/>
 * Maximum value in this matrix is 3 and it occurs 2 times.
 *
 * 1. For each integer N, find highest  bit set. (high)
 * 2. Find XOR of high and N
 * 3. if XOR is 0, max in number - 1, and it occurs N times.
 * 4. Find the value of set bits (high-1 to 1). This is our Max and it occurs XOR*2 times
 */
public class RoyAndMaximumXOR
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long N = scanner.nextLong();
            long highBit = Long.highestOneBit(N);
            long xor = highBit ^ N;
            if (xor == 0) {
                pw.println(N - 1 + " " + N);
            } else {
                long max = getMax(highBit);
                pw.println(max + " " + xor * 2);
            }
        }

        scanner.close();
        pw.close();
    }

    private static long getMax(long highBit)
    {
        long toReturn = highBit;
        while (highBit > 1) {
            highBit = highBit >> 1;
            toReturn |= highBit;
        }
        return toReturn;
    }
}
