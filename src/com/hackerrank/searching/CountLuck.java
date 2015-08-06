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

package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

public class CountLuck
{
    private final char[][] matrix;
    private final Point start;
    private final int[][] visit;
    private final int N;
    private final int M;

    public CountLuck(char[][] matrix, int p1, int p2, int N, int M)
    {
        this.matrix = matrix;
        this.start = new Point(p1, p2, 0);
        visit = new int[N][M];
        this.N = N;
        this.M = M;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            char[][] matrix = new char[N][M];
            int p1 = -1, p2 = -1;
            for (int n = 0; n < N; n++) {
                char[] array = scanner.next().toCharArray();
                for (int m = 0; m < M; m++) {
                    if (array[m] == 'M') {
                        p1 = n;
                        p2 = m;
                    }
                }
                matrix[n] = array;
            }

            int K = scanner.nextInt();

            CountLuck luck = new CountLuck(matrix, p1, p2, N, M);
            int L = luck.countLuck();
            if (K == L) {
                pw.println("Impressed");
            } else {
                pw.println("Oops!");
            }
        }
        scanner.close();
        pw.close();
    }

    private int countLuck()
    {
        int branches = 0;
        Stack<Point> dfsStack = new Stack<Point>();
        dfsStack.add(start);

        while (!dfsStack.isEmpty()) {
            Point p = dfsStack.pop();
            int x = p.getX();
            int y = p.getY();
            int br = p.getBranches();
            if (matrix[x][y] == '*') {
                branches = br;
                break;
            }

            int count = 0;
            boolean left = false, right = false, up = false, down = false;
            if (y > 0 && visit[x][y - 1] == 0 && (matrix[x][y - 1] == '.' || matrix[x][y - 1] == '*')) {
                visit[x][y - 1] = 1;
                count++;
                left = true;
            }
            if (y < M - 1 && visit[x][y + 1] == 0 && (matrix[x][y + 1] == '.' || matrix[x][y + 1] == '*')) {
                visit[x][y + 1] = 1;
                count++;
                right = true;

            }
            if (x > 0 && visit[x - 1][y] == 0 && (matrix[x - 1][y] == '.' || matrix[x - 1][y] == '*')) {
                visit[x - 1][y] = 1;
                count++;
                up = true;
            }
            if (x < N - 1 && visit[x + 1][y] == 0 && (matrix[x + 1][y] == '.' || matrix[x + 1][y] == '*')) {
                visit[x + 1][y] = 1;
                count++;
                down = true;
            }

            if (count > 1) {
                br++;
            }
            if (left) {
                dfsStack.add(new Point(x, y - 1, br));
            }
            if (right) {
                dfsStack.add(new Point(x, y + 1, br));
            }
            if (up) {
                dfsStack.add(new Point(x - 1, y, br));
            }
            if (down) {
                dfsStack.add(new Point(x + 1, y, br));
            }
        }


        return branches;
    }

    private static class Point
    {
        private final int x;
        private final int y;
        private final int branches;


        public Point(int x, int y, int branches)
        {
            this.x = x;
            this.y = y;
            this.branches = branches;
        }

        public int getX()
        {
            return x;
        }

        public int getY()
        {
            return y;
        }

        public int getBranches()
        {
            return branches;
        }
    }
}
