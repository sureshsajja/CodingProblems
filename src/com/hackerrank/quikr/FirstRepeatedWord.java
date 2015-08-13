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

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  13/08/15
 * Version : v1
 */
public class FirstRepeatedWord {


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));


        String s = scanner.nextLine();
        pw.println(firstRepeatedWord(s));


        pw.close();
    }

    private static String firstRepeatedWord(String s) {

        StringTokenizer tokenizer = new StringTokenizer(s, " \t,;:-.", false);
        Set<String> read = new HashSet<String>();
        while (tokenizer.hasMoreElements()) {
            String word = tokenizer.nextToken();
            if (!read.contains(word)) {
                read.add(word);
            } else {
                return word;
            }
        }

        return null;

    }

}
