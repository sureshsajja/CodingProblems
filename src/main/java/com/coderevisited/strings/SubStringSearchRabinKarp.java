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
import java.math.BigInteger;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * User :  Suresh
 * Date :  09/07/15
 * Version : v1
 */
public class SubStringSearchRabinKarp {

    private static final int SEED_PRIME = 257;
    private static final int PRIME = BigInteger.probablePrime(31, new Random()).intValue();

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        String pattern = next();
        String text = next();

        if (text.length() < pattern.length()) {
            pw.println("No Match");
        }

        int pow = 1;
        for (int i = 1; i < pattern.length(); i++) {
            pow = (pow * SEED_PRIME) % PRIME;
        }

        int patternHash = hash(pattern, pattern.length());
        int textHash = hash(text, pattern.length());

        if ((patternHash == textHash) && verify(text, pattern, 0))
            pw.println("Match found at " + 0);


        for (int i = pattern.length(); i < text.length(); i++) {
            textHash = (textHash + PRIME - pow * text.charAt(i - pattern.length()) % PRIME) % PRIME;
            textHash = (textHash * SEED_PRIME + text.charAt(i)) % PRIME;
            int offset = i - pattern.length() + 1;
            if ((patternHash == textHash) && verify(text, pattern, offset))
                pw.println("Match found at " + offset);
        }
        reader.close();
        pw.close();
    }

    private static int hash(String s, int length) {
        int h = 0;
        for (int j = 0; j < length; j++)
            h = (SEED_PRIME * h + s.charAt(j)) % PRIME;
        return h;
    }

    private static boolean verify(String txt, String pattern, int offset) {
        for (int j = 0; j < pattern.length(); j++)
            if (pattern.charAt(j) != txt.charAt(offset + j))
                return false;
        return true;
    }
}
