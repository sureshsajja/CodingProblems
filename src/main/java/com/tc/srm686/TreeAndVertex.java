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

package com.tc.srm686;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 29/03/16
 * Version : v1
 */
public class TreeAndVertex {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static String nextLine() throws IOException {
        return reader.readLine();
    }

    private static int[] nextIntArray() throws IOException {

        tokenizer = new StringTokenizer(reader.readLine());
        int[] array = new int[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            array[i++] = parseInt(tokenizer.nextToken());
        }

        return array;
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    private static long nextLong() throws IOException {
        return parseLong(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int[] array = nextIntArray();
        pw.println(get(array));


        reader.close();
        pw.close();

    }

    private static int get(int[] array) {

        Map<Integer, Integer> vertexToEdges = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            int u = i + 1;
            int count = 1;
            if (vertexToEdges.containsKey(v)) {
                count += vertexToEdges.get(v);
            }
            vertexToEdges.put(v, count);

            count = 1;
            if (vertexToEdges.containsKey(u)) {
                count += vertexToEdges.get(u);
            }
            vertexToEdges.put(u, count);
        }

        int max = 0;
        for (Map.Entry<Integer, Integer> entry : vertexToEdges.entrySet()) {

            int localMax = entry.getValue();
            if (max < localMax) {
                max = localMax;
            }

        }

        return max;

    }
}
