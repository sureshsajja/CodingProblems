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
 * Date :  27/07/15
 * Version : v1
 */

/**
 * https://www.hackerearth.com/problem/algorithm/monk-and-iq/
 */
public class MonkAndIQ {

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

        int C = nextInt();
        int P = nextInt();
        int N = nextInt();
        int[] array = new int[C];

        for (int n = 0; n < C; n++) {
            array[n] = -1;
        }


        StringTokenizer _tokenizer = new StringTokenizer(reader.readLine());
        int index = 0;
        while (_tokenizer.hasMoreElements()) {
            int i = Integer.parseInt(_tokenizer.nextToken());
            array[index++] = i;
        }

        PriorityQueue<Course> queue = new PriorityQueue<Course>(100000, new Comparator<Course>() {
            @Override
            public int compare(Course i, Course j) {
                return i.z > j.z ? 1 : (i.z == j.z ? (i.index > j.index ? 1 : (i.index == j.index ? 0 : -1)) : -1);
            }
        });

        for (int i = 0; i < C; i++) {
            queue.add(new Course(array[i], i));
        }

        _tokenizer = new StringTokenizer(reader.readLine());
        for (int p = 0; p < P; p++) {
            int i = 0;
            if (_tokenizer.hasMoreElements()) {
                i = Integer.parseInt(_tokenizer.nextToken());
            }
            Course c = queue.poll();
            pw.print(c.index + 1);
            pw.print(" ");
            c.addIQ(i);
            queue.add(c);
        }


        reader.close();
        pw.close();
    }

    private static class Course {
        int z;
        int index;
        int first = -1;
        int second = -1;
        int c = 0;


        public Course(int iq, int index) {
            this.index = index;
            if (iq != -1) {
                z = iq;
                first = iq;
                this.c = 1;
            } else {
                this.z = 0;
            }

        }

        public void addIQ(int i) {
            if (first == -1) {
                first = i;
                z = first;
                this.c = 1;
            } else {
                second = first;
                first = i;
                c++;
                z = (first + second) * c;
            }
        }
    }
}
