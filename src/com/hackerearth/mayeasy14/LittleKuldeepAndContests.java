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

package com.hackerearth.mayeasy14;

import java.util.Scanner;

/**
 * https://www.hackerearth.com/problem/algorithm/little-kuldeep-and-contests/
 */
public class LittleKuldeepAndContests {
    private static int[] day = new int[24 * 60];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        boolean overlap = false;
        for (int t = 0; t < T; t++) {
            String[] startEnd = scanner.next().split("-");
            if (!overlap) {
                String[] startHHSS = startEnd[0].split(":");
                int HH = Integer.parseInt(startHHSS[0]);
                int MM = Integer.parseInt(startHHSS[1]);
                int startIndex = HH * 60 + MM;

                String[] endHhSs = startEnd[1].split(":");
                HH = Integer.parseInt(endHhSs[0]);
                MM = Integer.parseInt(endHhSs[1]);
                int endIndex = HH * 60 + MM;

                for (int i = startIndex; i < endIndex; i++) {
                    if (day[i] != 0) {
                        overlap = true;
                        break;
                    }
                    day[i] = 1;
                }
            }
        }
        if (overlap) {
            System.out.println("Will need a moderator!");
        } else {
            System.out.println("Who needs a moderator?");
        }
    }

}
