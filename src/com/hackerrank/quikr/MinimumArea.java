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

package com.hackerrank.quikr;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  13/08/15
 * Version : v1
 */

/**
 * NOT WORKING
 */
public class MinimumArea {

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

        int[] x = new int[N];
        int[] y = new int[N];

        for (int n = 0; n < N; n++) {
            x[n] = nextInt();
        }

        for (int n = 0; n < N; n++) {
            y[n] = nextInt();
        }

        int k = nextInt();

        pw.println(minarea(x, y, k));

        reader.close();
        pw.close();
    }

    private static int minarea(int[] x, int[] y, int k) {


        List<Point> xSortedPoints = new ArrayList<>();
        List<Point> ySortedPoints = new ArrayList<>();

        for (int i = 0; i < x.length; i++) {
            Point p = new Point(x[i], y[i]);
            xSortedPoints.add(p);
            ySortedPoints.add(p);
        }

        Collections.sort(xSortedPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.x < o2.x) {
                    return -1;
                } else if (o1.x > o2.x) {
                    return 1;
                } else {
                    return 0;
                }

            }
        });


        Collections.sort(ySortedPoints, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.y < o2.y) {
                    return 1;
                } else if (o1.y > o2.y) {
                    return -1;
                } else {
                    return 0;
                }

            }
        });


        Set<Point> removed = new HashSet<>();
        int xIndex = 0;
        int yIndex = 0;
        int xAxis = xSortedPoints.get(0).x - 1;
        int yAxis = ySortedPoints.get(0).y + 1;


        int totalCovered = x.length;

        while (totalCovered != k) {
            xAxis++;
            yAxis--;

            Point toremove = xSortedPoints.get(xIndex);
            while (toremove.x <= xAxis && xIndex < x.length - 1) {
                removed.add(toremove);
                xIndex++;
                toremove = xSortedPoints.get(xIndex);
            }

            toremove = ySortedPoints.get(yIndex);
            while (toremove.x >= yAxis && yIndex < y.length - 1) {
                removed.add(toremove);
                yIndex++;
                toremove = ySortedPoints.get(yIndex);
            }

            totalCovered = x.length - removed.size();
        }
        return (yAxis - xAxis) * (yAxis - xAxis);


    }

    private static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Point) {
                Point that = (Point) obj;
                if (this.x == that.x) {
                    if (this.y == that.y)
                        return true;
                }
            }
            return false;
        }
    }

}
