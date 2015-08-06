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

package com.geeksforgeeks;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneWords
{
    private static final String[] words = new String[]{"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            char[] chars = scanner.next().toCharArray();
            int[] number = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                number[i] = chars[i] - '0';
            }
            char[] result = new char[chars.length];
            printWords(number, 0, result, pw);
            pw.println();
        }


        scanner.close();
        pw.close();
    }

    private static void printWords(int[] number, int current, char[] result, PrintWriter pw)
    {
        if (current == number.length) {
            pw.print(result);
            pw.print(" ");
            return;
        }

        if (number[current] == 0 || number[current] == 1) {
            printWords(number, current + 1, result, pw);
        }

        for (int i = 0; i < words[number[current]].length(); i++) {
            result[current] = words[number[current]].charAt(i);
            printWords(number, current + 1, result, pw);
        }

    }


}
