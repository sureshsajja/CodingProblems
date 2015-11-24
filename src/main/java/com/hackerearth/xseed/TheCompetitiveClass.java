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
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  12/07/15
 * Version : v1
 */

/**
 * 1. sort based on marks
 * 2. If marks are equal, set prev rank
 * 3. keep track of no of marks greater than current mark
 */
public class TheCompetitiveClass {

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

        Mark[] marks = new Mark[N];
        for (int n = 0; n < N; n++) {
            marks[n] = new Mark(nextInt(), 0, n);
        }

        Arrays.sort(marks, new MarksComparator());


        Mark prev = marks[N - 1];
        prev.rank = 1;
        int noOfGreaterMarks = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (prev.marks == marks[i].marks) {
                marks[i].rank = prev.rank;
            } else {
                marks[i].rank = noOfGreaterMarks + 1;
            }
            noOfGreaterMarks++;
            prev = marks[i];
        }

        Arrays.sort(marks, new IndexComparator());
        for (int i = 0; i < N; i++) {
            pw.print(marks[i].rank + " ");
        }

        pw.println();
        reader.close();
        pw.close();
    }

    private static class Mark {
        private int marks;
        private int rank;
        private int index;

        public Mark(int marks, int rank, int index) {
            this.marks = marks;
            this.index = index;
            this.rank = rank;
        }
    }

    private static class MarksComparator implements Comparator<Mark> {

        @Override
        public int compare(Mark m1, Mark m2) {
            if (m1.marks < m2.marks)
                return -1;
            else if (m1.marks > m2.marks)
                return 1;
            else
                return 0;
        }
    }

    private static class IndexComparator implements Comparator<Mark> {

        @Override
        public int compare(Mark m1, Mark m2) {
            if (m1.index < m2.index)
                return -1;
            else if (m1.index > m2.index)
                return 1;
            else
                return 0;
        }
    }
}
