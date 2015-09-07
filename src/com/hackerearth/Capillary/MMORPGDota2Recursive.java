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

package com.hackerearth.Capillary;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  07/09/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/problem/algorithm/mmorpg-dota2-4/
 *
 * Optimal Substructure
 * ====================
 *
 * MinPoints at i = min{
 *     sunstroke + minPoints(i-1),
 *     tornado + minPoints(i-tornadoLength)
 * }
 */
public class MMORPGDota2Recursive {


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

        int ms = nextInt();
        int mt = nextInt();
        int lt = nextInt();

        int N = nextInt();

        Set<Integer> set = new TreeSet<>();

        for (int n = 0; n < N; n++) {
            set.add(nextInt());
        }

        Integer[] array = set.toArray(new Integer[set.size()]);


        pw.println(calculateMinPoints(array.length - 1, array, ms, mt, lt));


        reader.close();
        pw.close();
    }

    private static int calculateMinPoints(int i, Integer[] array, int ms, int mt, int lt) {
        if (i < 0)
            return 0;
        if (i == 0) {
            return ms > mt ? mt : ms;
        } else {
            int sun = ms + calculateMinPoints(i - 1, array, ms, mt, lt);
            int value = array[i] - lt;
            if (value < 0) {
                value = 0;
            }
            int index = Arrays.binarySearch(array, 0, i, value);
            if (index < 0) {
                index++;
            }
            index = Math.abs(index);
            int tornado = mt + calculateMinPoints(index - 1, array, ms, mt, lt);
            return sun < tornado ? sun : tornado;
        }
    }


}
