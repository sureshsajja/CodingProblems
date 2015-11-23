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

package com.hackerearth.zomato;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 23/11/15
 * Version : v1
 * https://www.hackerearth.com/problem/algorithm/maximum-occurrence-9/
 */
public class Maximumoccurrence {

    private static BufferedReader reader;

    private static String next() throws IOException {
        return reader.readLine();
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        String s = next();
        Map<Character, Integer> map = new TreeMap<>();
        for (char c : s.toCharArray()) {
            if (c != ' ') {
                Integer i = map.get(c);
                if (i == null) {
                    map.put(c, 1);
                } else {
                    map.put(c, i + 1);
                }
            }
        }

        char maxChar = ' ';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        pw.print(maxChar + " " + maxCount);

        reader.close();
        pw.close();

    }
}
