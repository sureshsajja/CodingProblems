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

package com.hackerearth.codemonk.heaps;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  22/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/code-monk-heaps-and-priority-queues/algorithm/monk-and-some-queries/
 */
public class MonkAndSomeQueries {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] array = new int[100001];
    private static PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(100000, new Comparator<Integer>() {
        @Override
        public int compare(Integer i, Integer j) {
            return i < (int) j ? 1 : (i == (int) j ? 0 : -1);
        }
    });

    private static PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();

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


        int N = nextInt();

        for (int i = 0; i < N; i++) {
            int q = nextInt();
            if (q == 1) {
                int a = nextInt();
                minQueue.add(a);
                maxQueue.add(a);
                array[a]++;
            } else if (q == 2) {
                int r = nextInt();
                if (array[r] != 0) {
                    array[r]--;
                } else
                    pw.println(-1);

            } else if (q == 3) {
                pw.println(getPeek(maxQueue));
            } else if (q == 4) {
                pw.println(getPeek(minQueue));
            }
        }

        reader.close();
        pw.close();
    }

    private static int getPeek(PriorityQueue<Integer> queue) {
        if (!queue.isEmpty()) {
            int min = queue.peek();
            while (array[min] == 0 && queue.size() > 1) {
                queue.remove(min);
                min = queue.peek();
            }
            if (array[min] != 0)
                return min;
        }
        return -1;
    }
}
