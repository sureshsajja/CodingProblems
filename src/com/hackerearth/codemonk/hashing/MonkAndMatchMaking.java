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

package com.hackerearth.codemonk.hashing;

import java.io.*;
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  08/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/code-monk-hashing/algorithm/monk-and-match-making/
 */
public class MonkAndMatchMaking {

    private static final int SEED_PRIME = 257;
    private static final int PRIME = BigInteger.probablePrime(31, new Random()).intValue();


    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

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

        String s = next();

        long[] pow = new long[s.length()];
        pow[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            pow[i] = (pow[i - 1] * SEED_PRIME) % PRIME;
        }

        long[] hash = new long[s.length() + 1];

        for (int j = 1; j < hash.length; j++)
            hash[j] = (SEED_PRIME * hash[j - 1] + s.charAt(j - 1)) % PRIME;

        int Q = nextInt();
        for (int q = 0; q < Q; q++) {
            int a = nextInt();
            int b = nextInt();
            int c = nextInt();
            int d = nextInt();

            long hash1 = (hash[b] - (hash[a - 1] * pow[b - a + 1]) % PRIME + PRIME) % PRIME;
            long hash2 = (hash[d] - (hash[c - 1] * pow[d - c + 1]) % PRIME + PRIME) % PRIME;

            if (hash1 == hash2) {
                pw.println("Yes");
            } else {
                pw.println("No");
            }
        }
        reader.close();
        pw.close();
    }
}
