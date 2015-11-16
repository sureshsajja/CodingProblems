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

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RollingHashDemo
{

    private static long longRandomPrime = BigInteger.probablePrime(31, new Random()).longValue();
    private static Map<Character, Long> primes = new HashMap<Character, Long>();
    private static Map<Character, Long> inverse = new HashMap<Character, Long>();

    static {

        primes.put('a', 3L);
        primes.put('b', 5L);
        primes.put('c', 7L);
        primes.put('d', 11L);
        primes.put('e', 13L);
        primes.put('f', 17L);
        primes.put('g', 19L);
        primes.put('h', 23L);
        primes.put('i', 29L);
        primes.put('j', 31L);
        primes.put('k', 37L);
        primes.put('l', 41L);
        primes.put('m', 43L);
        primes.put('n', 47L);
        primes.put('o', 53L);
        primes.put('p', 59L);
        primes.put('q', 61L);
        primes.put('r', 67L);
        primes.put('s', 71L);
        primes.put('t', 73L);
        primes.put('u', 79L);
        primes.put('v', 83L);
        primes.put('w', 89L);
        primes.put('x', 97L);
        primes.put('y', 101L);
        primes.put('z', 103L);
    }

    public static void main(String[] args)
    {
        String source = "thisisexampleofrollinghash";
        String pattern = "example";
        long hash = findHash(pattern, 7);
        System.out.println("Hash of \"example\" : " + hash);
        long sourceHash = findHash(source, pattern.length());
        System.out.println("Hash of \"" + source.substring(0, pattern.length()) + "\" : " + sourceHash);

        ModInverseCalculator inverseCalculator = new ModInverseCalculator(longRandomPrime);
        for (int i = pattern.length(); i < source.length(); i++) {
            char c = source.charAt(i - pattern.length());
            System.out.println("Removing char : " + c);
            if (!inverse.containsKey(c)) {
                inverse.put(c, inverseCalculator.modInverse(primes.get(c)));
            }
            sourceHash = (sourceHash * inverse.get(c)) % longRandomPrime;
            System.out.println("Adding char : " + source.charAt(i));
            sourceHash = (sourceHash * primes.get(source.charAt(i))) % longRandomPrime;
            int offset = i - pattern.length() + 1;
            System.out
                    .println("Hash of \"" + source.substring(offset, pattern.length() + offset) + "\" : " + sourceHash);
        }
    }

    private static long findHash(String source, int length)
    {
        long h = 1;
        for (int j = 0; j < length; j++) {
            h = h * primes.get(source.charAt(j)) % longRandomPrime;
        }
        return h;
    }
}
