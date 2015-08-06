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

package com.hackerearth.xseed;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  12/07/15
 * Version : v1
 */
public class AkashAndTooManyAssignments {

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

        int N = nextInt();
        int Q = nextInt();
        String s = next();
        char[] chars = s.toCharArray();
        for (int q = 0; q < Q; q++) {
            int i = nextInt();
            if (i == 0) {
                int index = nextInt();
                String c = next();
                chars[index - 1] = c.charAt(0);

            } else if (i == 1) {
                int left = nextInt();
                int right = nextInt();
                int k = nextInt();
                findSmallest(chars, left - 1, right - 1, k, pw);
            }
        }
        reader.close();
        pw.close();
    }

    public static void findSmallest(char[] chars, int left, int right, int k, PrintWriter pw) {

        List<Character> list = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            list.add(chars[i]);
        }

        Collections.sort(list);
        if (list.size() >= k) {
            pw.println(list.get(k - 1));
        } else {
            pw.println("Out of range");
        }
    }
}
