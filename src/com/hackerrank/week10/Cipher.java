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

package com.hackerrank.week10;

import java.io.*;
import java.util.BitSet;

public class Cipher
{

    private static final int BUFFER_SIZE = 8192;

    public static void main(String[] args)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        try {
            String[] intArray = reader.readLine().split(" ");
            int N = Integer.valueOf(intArray[0]);
            int K = Integer.valueOf(intArray[1]);
            BitSet A = new BitSet(N + K - 1);

            int offset = 0;
            char[] chars = new char[BUFFER_SIZE];

            int size = (N + K) / BUFFER_SIZE + 1;
            for (int i = 0; i < size; i++) {
                int len = reader.read(chars);
                for (int j = 0; j < len; j++) {
                    if (chars[j] == '1') {
                        A.set(j + offset);
                    }
                }
                offset += len;
            }

            BitSet B = new BitSet(N);
            if (A.get(0))
                B.set(0);
            if (B.get(0)) {
                pw.print("1");
            } else {
                pw.print("0");
            }
            boolean window = B.get(0);
            for (int i = 1; i < N; i++) {
                if (window ^ A.get(i)) {
                    B.set(i);
                }
                window ^= B.get(i);
                if (i >= K - 1) {
                    window ^= B.get(i - K + 1);
                }
                if (B.get(i)) {
                    pw.print("1");
                } else {
                    pw.print("0");
                }
            }


        } catch (IOException e) {
            //ignore

        } finally {
            try {
                reader.close();
                pw.close();
            } catch (IOException e) {
                //ignore
            }
        }


    }
}
