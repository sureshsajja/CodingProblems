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

package com.hackerearth.octobereasy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AGameForSoftDrinks
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int N1 = scanner.nextInt();
            int N2 = scanner.nextInt();
            int N3 = scanner.nextInt();

            boolean found = false;
            while (true) {
                if (N1 > 0 && N1 % 2 == 1) {
                    N1--;
                    found = true;
                }
                if (N2 > 0 && N2 % 2 == 1) {
                    N2--;
                    found = true;
                }
                if (N3 > 0 && N3 % 2 == 1) {
                    N3--;
                    found = true;
                }
                if (found) {
                    found = false;
                } else {
                    pw.println("Aishwarya");
                    break;
                }


                if (N1 > 0 && N1 % 2 == 0) {
                    N1--;
                    found = true;
                }
                if (N2 > 0 && N2 % 2 == 0) {
                    N2--;
                    found = true;
                }
                if (N3 > 0 && N3 % 2 == 0) {
                    N3--;
                    found = true;
                }
                if (found) {
                    found = false;
                } else {
                    pw.println("Ashima");
                    break;
                }


            }

        }

        scanner.close();
        pw.close();
    }


}
