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

package com.hackerearth;

import java.util.Scanner;

/**
 * Sherlock Holmes loves mind palaces! We all know that. A mind palace, according to Mr. Holmes is something that lets
 * him retrieve a given memory in the least time posible. For this, he structures his mind palace in a very special way.
 * Let a NxM Matrix denote the mind palace of Mr. Holmes. For fast retrieval he keeps each row and each column sorted.
 * Now given a memory X, you have to tell the position of the memory in Sherlock's mind palace.
 * Input
 * =====
 * Input begins with a line containing space separated N and M. The next N lines each contain M numbers, each referring to a memory
 * Y. The next line contains Q, the number of queries. The next Q lines contain a single element X, the memory you have
 * to search in Sherlock's mind palace.
 * <p/>
 * 5 5 -10 -5 -3 4 9 -6 -2 0 5 10 -4 -1 1 6 12 2 3 7 8 13 100 120 130 140 150 3 0 -2 170
 * <p/>
 * Output
 * ======
 * If Y is present in Mr. Holmes memory, output its position (0-based indexing). Else output "-1 -1"
 * (quotes for clarity only).
 * <p/>
 * 1 2 1 1 -1 -1
 * <p/>
 * Constraints
 * ===========
 * 2 ≤ N,M ≤ 1000 2 ≤ Q ≤ 1000 -10^9 ≤ X,Y ≤ 10^9
 */
public class MindPalaces
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        int N = scanner.nextInt();
        int[][] memory = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                memory[i][j] = scanner.nextInt();
            }
        }

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int number = scanner.nextInt();
            boolean found = false;

            int i = M - 1;
            int j = 0;
            while (i > -1 && j < N) {
                if (memory[i][j] < number) {
                    j++;
                } else if (memory[i][j] > number) {
                    i--;
                } else {
                    System.out.println(i + " " + j);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println(-1 + " " + -1);
            }
        }
    }


}
