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

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * Generate as many distinct primes P such that reverse (P) is also prime and is not equal to P.
 */
public class EmirpGenerator
{

    private static final int MAX = 1000000000;


    public static void main(String[] args)
    {
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long start = System.nanoTime();

        EmirpGenerator emirpGenerator = new EmirpGenerator();
        emirpGenerator.sieve(out);

        out.println((double) (System.nanoTime() - start) / 1000000000.0);
        out.close();

    }

    private static int reverse(int number)
    {
        int reverseNumber = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            number = number / 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
        }
        return reverseNumber;
    }

    private void sieve(PrintWriter out)
    {

        BitVector vector = new BitVector(MAX);
        int[] seq = new int[]{2, 4, 2, 4, 6, 2, 6, 4,
                2, 4, 6, 6, 2, 6, 4, 2,
                6, 4, 6, 8, 4, 2, 4, 2,
                4, 8, 6, 4, 6, 2, 4, 6,
                2, 6, 6, 4, 2, 4, 6, 2,
                6, 4, 2, 4, 2, 10, 2, 10};
        int index = 0;
        for (int i = 11; i < Math.sqrt(MAX); i += seq[index++]) {
            if (!vector.isSet(i)) {
                int index2 = index;
                for (int j = i * i; j < MAX; j = j + seq[index2++] * i) {
                    vector.setBit(j);
                    if (index2 == 48) {
                        index2 = 0;
                    }
                }

            }
            if (index == 48) {
                index = 0;
            }

        }


        index = 0;
        for (int i = 11; i < MAX; i += seq[index++]) {
            if (!vector.isSet(i)) {
                int reverse = reverse(i);
                if ((reverse & 1) == 1 && reverse < MAX && i < reverse && (reverse & 3) != 0 && reverse % 5 != 0 &&
                        reverse % 7 != 0) {
                    if (!vector.isSet(reverse)) {
                        out.println(i);
                    }
                }

            }
            if (index == 48) {
                index = 0;
            }
        }
    }

    private class BitVector
    {

        private int[] bitArray;

        public BitVector(long MAX)
        {
            bitArray = new int[(int) (MAX >> 6) + 1];
        }

        public void setBit(long i)
        {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            bitArray[index] = (bitArray[index]) | (1 << bit);
        }

        public boolean isSet(long i)
        {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            return ((bitArray[index]) & (1 << bit)) != 0;
        }
    }
}
