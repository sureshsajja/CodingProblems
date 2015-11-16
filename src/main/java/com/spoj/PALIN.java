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

package com.spoj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * http://www.spoj.com/problems/PALIN/
 */
public class PALIN {

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
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = nextInt();
        for (int i = 0; i < T; i++) {
            char[] numbers = next().toCharArray();
            String nextPalin = getNextPalin(numbers);
            pw.println(nextPalin);
        }
        reader.close();
        pw.close();

    }

    private static String getNextPalin(char[] numbers) {
        if (numbers.length == 1) {
            return "11";
        }
        int left = getLeftIndex(numbers);
        int right = getRightIndex(numbers);

        while (numbers[left] == numbers[right]) {
            left--;
            right++;
            if (left < 0) {
                return handlePalindrome(numbers);
            }
        }

        if (numbers[left] > numbers[right]) {
            while (left >= 0) {
                numbers[right] = numbers[left];
                right++;
                left--;
            }
            return new String(numbers);
        } else {
            return handlePalindrome(numbers);
        }
    }

    private static String handlePalindrome(char[] source) {

        char[] dest = incrementMiddle(source);
        copyMirror(dest);
        return new String(dest);
    }

    private static char[] incrementMiddle(char[] source) {
        int middle;
        if (source.length % 2 == 0) {
            middle = getLeftIndex(source);
        } else {
            middle = (source.length + 1) / 2 - 1;
        }

        int carry = 1;
        while (middle >= 0 && carry == 1) {
            if (source[middle] == '9') {
                source[middle] = '0';
                carry = 1;
            } else {
                source[middle] = (char) ((int) source[middle] + 1);
                carry = 0;
            }
            middle--;
        }

        if (carry == 1) {
            char[] dest = new char[source.length + 1];
            dest[0] = '1';
            System.arraycopy(source, 0, dest, 1, source.length);
            return dest;
        } else {
            return source;
        }
    }

    private static void copyMirror(char[] numbers) {

        int left = getLeftIndex(numbers);
        int right = getRightIndex(numbers);
        while (left >= 0) {
            numbers[right] = numbers[left];
            right++;
            left--;
        }
    }

    private static int getLeftIndex(char[] numbers) {
        if (numbers.length % 2 == 0) {
            return numbers.length / 2 - 1;
        } else {
            return (numbers.length - 1) / 2 - 1;
        }
    }

    private static int getRightIndex(char[] numbers) {
        if (numbers.length % 2 == 0) {
            return numbers.length / 2;
        } else {
            return (numbers.length + 1) / 2;
        }
    }
}
