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

package com.coderevisited.strings;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  17/08/15
 * Version : v1
 */
public class URLEncodeSpaces {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine(), "\t\n\r\f");
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
        for (int n = 0; n < N; n++) {
            String s = next();
            //create char array with maximum length
            char[] array = new char[200];
            int i = 0;
            for (char c : s.toCharArray()) {
                array[i++] = c;
            }

            pw.println(encodeSpaces(array, s.length()));

        }


        reader.close();
        pw.close();
    }

    private static String encodeSpaces(char[] array, int length) {

        int spaceCount = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == ' ') {
                spaceCount++;
            }
        }
        int maxLength = length + spaceCount * 2;
        int index = maxLength - 1;

        for (int i = length - 1; i >= 0; i--) {

            if (array[i] == ' ') {
                array[index--] = '0';
                array[index--] = '2';
                array[index--] = '%';
            } else {
                array[index--] = array[i];
            }
        }
        return new String(array).substring(0, maxLength);
    }


}
