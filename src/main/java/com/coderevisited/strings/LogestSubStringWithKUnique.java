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

package com.coderevisited.strings;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User    : Suresh
 * Date    : 12/07/16
 * Version : v1
 */
public class LogestSubStringWithKUnique {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;


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
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {

        String s = next();
        int k = nextInt();

        //Move window from 0 and up to K unique chars.
        Map<Character, Integer> hist = new HashMap<>();
        int i = 0;
        while (hist.size() < k) {
            if (i >= s.length()) {
                pw.println("Insufficient unique chars");
                return;
            }
            char c = s.charAt(i);
            int count = 0;
            if (hist.containsKey(c)) {
                count = hist.get(c);
            }
            hist.put(c, count + 1);
            i++;
        }

        //That is our max window for now.
        int max_start = 0;
        int max_end = i - 1;
        int curr_start = 0;

        //Start from i, if a new unique char found, remove from begging untill unique chars = k;
        for (; i < s.length(); i++) {

            //Add next char to hist
            char c = s.charAt(i);
            int count = 0;
            if (hist.containsKey(c)) {
                count = hist.get(c);
                hist.put(c, count + 1);
            }
            hist.put(c, count + 1);

            //if new chars exceeds K, start removing from front
            while (hist.size() > k) {
                char c1 = s.charAt(curr_start);
                int _count = hist.remove(c1);
                if (_count != 1) {
                    hist.put(c1, _count - 1);
                }
                curr_start++;
            }

            //Update max_end if required
            if (max_end - max_start < i - curr_start) {
                max_start = curr_start;
                max_end = i;
            }
        }

        for (int j = max_start; j <= max_end; j++) {
            pw.print(s.charAt(j));
        }

        pw.println();

    }

}
