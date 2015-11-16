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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Given an even number check if it can be represented as a sum of two primes
 * INPUT
 * =====
 * 2 4 8
 * <p/>
 * OUTPUT
 * ======
 * Can be represented as sum of two primes :2+2 Can be represented as sum of two primes :3+5
 */
public class SumAsPrimeNumbers
{

    public static void main(String[] args)
    {
        Integer[] primes = findPrimes();

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();

            int i = 0;
            int firstPrime = primes[i++];
            int secondPrime = 0;
            boolean found = false;
            while (firstPrime <= n / 2) {
                int secondPrimeIndex = Arrays.binarySearch(primes, n - firstPrime);
                if (secondPrimeIndex >= 0) {
                    found = true;
                    secondPrime = primes[secondPrimeIndex];
                    break;
                }
                firstPrime = primes[i++];
            }
            if (found) {
                System.out.println(n + " can be represented as sum of two primes :" + firstPrime + "+" + secondPrime);
            } else {
                System.out.println(n + " can't be represented as sum of two primes");
            }


        }
    }

    private static Integer[] findPrimes()
    {

        int MAX = 100000;
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

        List<Integer> primes = new ArrayList<Integer>();
        primes.add(2);
        primes.add(3);
        primes.add(5);
        primes.add(7);


        index = 0;
        for (int i = 11; i < MAX; i += seq[index++]) {
            if (!vector.isSet(i)) {
                primes.add(i);
            }
            if (index == 48) {
                index = 0;
            }
        }
        Integer[] array = new Integer[primes.size()];
        primes.toArray(array);
        return array;

    }

    private static class BitVector
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
