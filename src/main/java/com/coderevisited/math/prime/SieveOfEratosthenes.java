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

package com.coderevisited.math.prime;

import java.util.BitSet;

public class SieveOfEratosthenes
{
    private static int MAX = 1000000000;
    private static BitSet bitSet = new BitSet(MAX);

    public static void main(String[] args)
    {

        long start = System.nanoTime();

        sieve();

        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);

    }

    private static void sieve()
    {
        for (int i = 3; i < Math.sqrt(MAX); i += 2) {
            if (!bitSet.get(i)) {
                for (int j = i * i; j < MAX; j += i) {
                    bitSet.set(j);
                }
            }
        }

        int count = 1;
        for (int i = 3; i < MAX; i += 2) {
            if (!bitSet.get(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
