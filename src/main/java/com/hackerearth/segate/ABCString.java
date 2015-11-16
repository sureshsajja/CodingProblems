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

package com.hackerearth.segate;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  06/09/15
 * Version : v1
 */
public class ABCString {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static BigInteger THREE = BigInteger.valueOf(3);
    private static BigInteger TWO = BigInteger.valueOf(2);
    private static int MOD = 1000000000 + 7;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));


        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int n = nextInt();
            pw.println(findPermutations(n));
        }


        reader.close();
        pw.close();
    }

    private static int findPermutations(int n) {
        long one = raiseMtoN(3L, (long) n);
        long two = (raiseMtoN(2, n) * (3L)) % MOD;
        return (int) ((one + MOD - two + 3L) % MOD);
    }

    private static long raiseMtoN(long M, long n) {
        if (n == 0) return 1L;
        if (n == 1) return M;
        if ((n & 1) == 0) {
            long value = ((M * M) % MOD);
            return raiseMtoN(value, n / 2);
        } else {
            long value = ((M * M) % MOD);
            return ((M * raiseMtoN(value, n / 2)) % MOD);
        }
    }
}
