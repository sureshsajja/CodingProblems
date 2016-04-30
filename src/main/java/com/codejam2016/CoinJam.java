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
 */

package com.codejam2016;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 09/04/16
 * Version : v1
 */
public class CoinJam {

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


        int T = nextInt();
        for (int t = 1; t <= T; t++) {
            int k = nextInt();
            int N = nextInt();
            long LOW = (long) Math.pow(2, k - 1) + 1L;
            long HIGH = (long) Math.pow(2, k) - 1L;

            pw.println("Case #" + t + ":");

            for (long i = LOW, count = 0; i <= HIGH && count < N; i += 2) {
                String bits = Long.toString(i, 2);

                List<Long> factors = new LinkedList<>();

                for (int j = 2; j <= 10; j++) {
                    long a = Long.valueOf(bits, j);
                    long f = getFactors(a);
                    if (f == -1)
                        break;
                    factors.add(f);
                }

                if (factors.size() != 9)
                    continue;

                pw.print(bits);

                for (long factor : factors) {
                    pw.print(" " + factor);
                }
                pw.println();
                count++;
            }
        }
        reader.close();
        pw.close();

    }


    public static long getFactors(long n) {
        if (n <= 3) {
            return -1;
        }
        if (n % 2 == 0) {
            return 2;
        }
        if (n % 3 == 0) {
            return 3;
        } else {
            long sqrtN = (long) Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0) {
                    return i;
                }
                if (n % (i + 2) == 0) {
                    return i + 2;
                }

            }
            return -1;
        }
    }
}
