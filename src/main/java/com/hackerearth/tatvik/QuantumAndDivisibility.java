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

package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/quantum-and-divisibility-2/
 */
public class QuantumAndDivisibility {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int d = scanner.nextInt();

            Map<Integer, Long> afactors = primeFactors(a);
            updateFactors(afactors, b);

            Map<Integer, Long> cfactors = primeFactors(c);
            updateFactors(cfactors, d);


            if (compareFactors(afactors, cfactors))
                pw.println("Divisible");
            else
                pw.println("Not divisible");

        }

        scanner.close();
        pw.close();
    }

    private static boolean compareFactors(Map<Integer, Long> afactors, Map<Integer, Long> cfactors) {
        for (Integer cfactor : cfactors.keySet()) {
            if (afactors.containsKey(cfactor)) {
                if (cfactors.get(cfactor) > afactors.get(cfactor)) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    private static void updateFactors(Map<Integer, Long> factors, long b) {

        if (b == 0) {
            factors.clear();
        } else {
            for (Integer factor : factors.keySet()) {
                factors.put(factor, factors.get(factor) * b);
            }
        }

    }

    private static Map<Integer, Long> primeFactors(int a) {

        Map<Integer, Long> factors = new HashMap<>();

        while (a % 2 == 0) {
            a = a / 2;
            addToMap(factors, 2);
        }

        while (a % 3 == 0) {
            a = a / 3;
            addToMap(factors, 3);
        }

        for (int i = 5; i <= Math.sqrt(a); i += 6) {
            while (a % i == 0) {
                a = a / i;
                addToMap(factors, i);
            }
            while (a % (i + 2) == 0) {
                a = a / (i + 2);
                addToMap(factors, i + 2);
            }
        }
        if (a > 2) {
            addToMap(factors, a);
        }

        return factors;
    }

    private static void addToMap(Map<Integer, Long> factors, int factor) {
        if (factors.containsKey(factor)) {
            factors.put(factor, factors.get(factor) + 1);
        } else {
            factors.put(factor, 1L);
        }
    }
}
