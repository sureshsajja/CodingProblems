/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Suresh Sajja
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

package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ICPCTeam
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] knownTopics = new String[N];
        for (int n = 0; n < N; n++) {
            knownTopics[n] = scanner.next();
        }
        int maxKnown = 0;
        int maxKnownGroup = 0;
        for (int i = 0; i < N - 1; i++) {
            String si = knownTopics[i];
            for (int j = i; j < N; j++) {
                String sj = knownTopics[j];
                int known = 0;
                for (int k = 0; k < M; k++) {
                    if (si.charAt(k) == '1' || sj.charAt(k) == '1') {
                        known++;
                    }
                }
                if (known > maxKnown) {
                    maxKnown = known;
                    maxKnownGroup = 1;
                } else if (known == maxKnown) {
                    maxKnownGroup++;
                }
            }
        }

        pw.println(maxKnown);
        pw.println(maxKnownGroup);

        scanner.close();
        pw.close();

    }
}
