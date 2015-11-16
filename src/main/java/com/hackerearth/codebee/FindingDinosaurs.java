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

package com.hackerearth.codebee;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * User : Suresh
 * Date : 25/04/15
 */

/**
 * Ross and Rachel are on a date. Ross, being the super geek he is, takes Rachel to see dinosaur exhibits.
 * Each dinosaur has a name and K attributes which are described by an ordered K-tuple ( A1, A2, A3,..., AK ). Each attribute Ai is an integer between 0 to L inclusive. Ross tells Rachel about N dinosaurs. For each dinosaur, he tells her its name and gives her the K-tuple describing its attributes.
 * Afterwards, he wants to play a quiz with Rachel. He gives Rachel Q K-tuples and ask her which dinosaur they belongs to. As Rachel loves Ross and doesn't want him to think she wasn't paying attention, she wants to answer all questions correctly. Help her in this task.
 * <p/>
 * Input:
 * The first line contains N, K, L and Q, the number of dinosaurs, the size of the K-tuple, the maximum value of any attribute and the number of questions that Ross asks.
 * N lines follow. The next ith line contains a string which is the name of the ith dinosaur and K space separated integer which are the attributes for the ith dinosaur.
 * Q lines follow. The next ith line contains K space separated integer denoting a K-tuple.
 * <p/>
 * Output:
 * For each question, output the name of the dinosaur that the K-tuple belongs to.
 * It is also possible that Ross is asking a trick question and the tuple doesn't describe any dinosaur. In such a case, output "You cant fool me :P" (Quotes are for clarity)
 * <p/>
 * Constraints:
 * 1<=N<=100000
 * 1<=K<=5
 * 1<=L<=15
 * 1<=Q<=100000
 * 0<=Ai<=L
 * 1<=Length of Dinosaur's name<=10
 * Dinosaur's name will contain only lowercase alphabets [a-z].
 * <p/>
 * Note:
 * No two dinosaurs will have the same K-tuple or name.
 * <p/>
 * Sample Input
 * ============
 * 5 3 9 5
 * baryonyx 5 1 7
 * jobaria 1 2 3
 * oviraptor 9 7 1
 * troodon 6 9 5
 * minmi 7 4 5
 * 9 7 1
 * 1 2 3
 * 5 8 8
 * 1 2 3
 * 7 4 5
 * <p/>
 * <p/>
 * Sample Output
 * =============
 * oviraptor
 * jobaria
 * You cant fool me :P
 * jobaria
 * minmi
 * <p/>
 * Algorithm:
 * =========
 * This is just a demonstration of Hashcode implementation
 * http://stackoverflow.com/questions/113511/hash-code-implementation
 */
public class FindingDinosaurs {

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


        int N = nextInt();
        int K = nextInt();
        int L = nextInt();
        int Q = nextInt();


        Map<Integer, String> dinosaurs = new HashMap<>();
        for (int n = 0; n < N; n++) {
            String value = next();

            int key = 1;
            for (int k = 0; k < K; k++) {
                int a = nextInt();
                key = 31 * key + a;
            }
            dinosaurs.put(key, value);
        }

        for (int q = 0; q < Q; q++) {
            int key = 1;
            for (int k = 0; k < K; k++) {
                int a = nextInt();
                key = 31 * key + a;
            }
            if (dinosaurs.get(key) != null) {
                pw.println(dinosaurs.get(key));
            } else {
                pw.println("You cant fool me :P");
            }
        }

        reader.close();
        pw.close();
    }


}
