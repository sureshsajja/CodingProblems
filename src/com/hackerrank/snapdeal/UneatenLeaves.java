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

package com.hackerrank.snapdeal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. Include the cardinalities of the sets.
 * 2. Exclude the cardinalities of the pairwise intersections.
 * 3. Include the cardinalities of the triple-wise intersections.
 * 4. Exclude the cardinalities of the quadruple-wise intersections.
 * 5. Include the cardinalities of the quintuple-wise intersections.
 * 6. Continue, until the cardinality of the n-tuple-wise intersection is included (if n is odd) or excluded (n even).
 * <p/>
 * http://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
 */
public class UneatenLeaves
{

    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int res;
        int _N;
        _N = 1000000000;
        int[] _A = new int[]{9, 2, 4, 5, 6, 12, 1045, 5345, 4546, 343, 35345, 45345};
        res = countUneatenLeavesBruteForce(_N, _A);
        pw.println(res);
        res = countUneatenLeaves(_N, _A);
        pw.println(res);
        pw.close();
    }

    private static int countUneatenLeaves(int n, int[] a)
    {

        int factors = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        findFactorialsOfAllCombinations(0, a, 0, new int[a.length], map, n);
        for (int key : map.keySet()) {
            if ((key & 1) != 1) {
                List<Integer> list = map.get(key);
                for (int i : list) {
                    factors -= i;
                }
            } else {
                List<Integer> list = map.get(key);
                for (int i : list) {
                    factors += i;
                }
            }
        }

        return n - factors;
    }


    private static void findFactorialsOfAllCombinations(int start, int[] array, int K, int[] result, Map<Integer, List<Integer>> map, int N)
    {
        if (K > 0) {
            if (!map.containsKey(K)) {
                map.put(K, new ArrayList<Integer>());
            }
            List<Integer> list = map.get(K);
            int[] temp = new int[K];
            System.arraycopy(result, 0, temp, 0, K);
            int factors = (int) Math.floor(N / lcm(temp));
            list.add(factors);
        }
        for (int i = start; i < array.length; i++) {
            result[K] = array[i];
            findFactorialsOfAllCombinations(i + 1, array, K + 1, result, map, N);
        }
    }


    private static int lcm(int[] input)
    {
        int result = input[0];
        for (int i = 1; i < input.length; i++) result = lcm(result, input[i]);
        return result;
    }

    private static int countUneatenLeavesBruteForce(int N, int[] A)
    {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            boolean found = false;
            for (int j : A) {
                if (i >= j && i % j == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;
            }
        }
        return count;
    }

    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b)
    {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}

