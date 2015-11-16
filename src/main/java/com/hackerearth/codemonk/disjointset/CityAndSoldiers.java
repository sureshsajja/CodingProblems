
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

package com.hackerearth.codemonk.disjointset;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class CityAndSoldiers
{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] id;

    private static String next() throws IOException
    {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException
    {
        return parseInt(next());
    }

    private static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = nextInt();
        int K = nextInt();

        id = new int[N];

        for (int i = 0; i < N; i++) {
            id[i] = i;
        }

        for (int k = 0; k < K; k++) {
            int o = nextInt();
            if (o == 1) {
                int p = nextInt();
                int q = nextInt();
                union(p - 1, q - 1);
            } else if (o == 2) {
                int a = nextInt();
                union2(a);
            } else if (o == 3) {
                int a = nextInt();
                pw.println(find(a) + 1);
            }
        }

        reader.close();
        pw.close();

    }

    public static void union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        id[rootP] = rootQ;
    }

    public static void union2(int q)
    {
        int rootP = find(q);
        if (rootP == q) {
            return;
        }
        id[rootP] = q;
    }

    public static int find(int p)
    {
        int root = p;
        while (root != id[root]) {
            root = id[root];
        }
        while (p != root) {
            int newp = id[p];
            id[p] = root;
            p = newp;
        }
        return root;
    }

}
