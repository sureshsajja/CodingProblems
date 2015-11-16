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

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Given a string, find whether it has any permutation of another string. For example, given "abcdefg" and "ba", it
 * should return true, because "abcdefg" has substring "ab", which is a permutation of "ba".
 * <p/>
 * Algorithm 1. Calculate 'PH' as Pattern Hash using prime code for each character 2. populate histogram of characters
 * in the pattern 3. calculate 'SH' as Hash of source string up to length of pattern 4. if ('PH' != 'SH') Remove leading
 * digit, add trailing digit 5. if ('PH' == 'SH') check for exact match using histogram
 * <p/>
 * input:
 * 1
 * hack indiahacks
 * <p/>
 * output:
 * YES
 */
public class AnagramSearch
{

    private static Map<Character, Long> primes = new HashMap<Character, Long>();
    //Prime number generated from BigInteger.probablePrime(31, new Random())
    private static long longRandomPrime = 1895071303;
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

        //'3', '5' .... modulo large prime generated
        inverse.put('a', 1263380869L);
        inverse.put('b', 1137042782L);
        inverse.put('c', 270724472L);
        inverse.put('d', 1378233675L);
        inverse.put('e', 1166197725L);
        inverse.put('f', 1672121738L);
        inverse.put('g', 997405949L);
        inverse.put('h', 164788809L);
        inverse.put('i', 1045556581L);
        inverse.put('j', 855838653L);
        inverse.put('k', 153654430L);
        inverse.put('l', 785761272L);
        inverse.put('m', 1013642790L);
        inverse.put('n', 1854750637L);
        inverse.put('o', 1001169745L);
        inverse.put('p', 1027835283L);
        inverse.put('q', 1801871075L);
        inverse.put('r', 1442516962L);
        inverse.put('s', 1654850997L);
        inverse.put('t', 571117379L);
        inverse.put('u', 911553285L);
        inverse.put('v', 182657475L);
        inverse.put('w', 21292936L);
        inverse.put('x', 1719239945L);
        inverse.put('y', 450313973L);
        inverse.put('z', 1251115035L);
    }


    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        for (int i = 0; i < K; i++) {
            String pattern = scanner.next();
            String source = scanner.next();

            char[] sourceChars = source.toCharArray();
            char[] patternChars = pattern.toCharArray();

            Map<Character, Integer> charMap = new HashMap<Character, Integer>(26);
            populatePattern(patternChars, charMap);

            int l = pattern.length();

            long patternHash = hash(pattern, l);
            long sourceHash = hash(source, l);

            boolean found = false;
            if ((patternHash == sourceHash) && check(sourceChars, 0, l, new HashMap<Character, Integer>(charMap))) {
                found = true;
            }

            for (int j = l; j < source.length(); j++) {
                if (found) {
                    break;
                }

                // Remove leading digit, add trailing digit, check for match.
                sourceHash = (sourceHash * inverse.get(source.charAt(j - l))) % longRandomPrime;
                sourceHash = (sourceHash * primes.get(source.charAt(j))) % longRandomPrime;

                // match
                int offset = j - l + 1;
                if ((patternHash == sourceHash) &&
                        check(sourceChars, offset, l, new HashMap<Character, Integer>(charMap))) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static long hash(String source, int length)
    {
        long h = 1;
        for (int j = 0; j < length; j++) {
            h = h * primes.get(source.charAt(j)) % longRandomPrime;
        }
        return h;
    }

    private static boolean check(char[] sourceChars, int offset, int length, Map<Character, Integer> charMap)
    {

        for (int i = 0; i < length; i++) {
            char c = sourceChars[offset + i];

            if (charMap.containsKey(c)) {
                charMap.put(c, charMap.get(c) - 1);
                if (charMap.get(c) == 0) {
                    charMap.remove(c);
                }

                if (charMap.size() == 0) {
                    return true;
                }
            } else {
                break;
            }
        }
        return false;

    }

    private static void populatePattern(char[] pattern, Map<Character, Integer> charMap)
    {
        for (char c : pattern) {
            if (charMap.get(c) == null) {
                charMap.put(c, 1);
            } else {
                charMap.put(c, charMap.get(c) + 1);
            }
        }
    }


}
