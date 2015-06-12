package com.hackerearth.indiahacks2013;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 12/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/modify-sequence/
 */
public class ModifySequence {


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
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int N = nextInt();
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = nextInt();
        }

        // Arrays.sort(array);

        boolean yes = true;

        for (int i = 0; i < N - 1; i++) {
            array[i + 1] -= array[i];
            if (array[i + 1] < 0) {
                yes = false;
                break;
            }

        }


        if (array[N - 1] == 0 && yes) {
            pw.println("YES");
        } else {
            pw.println("NO");
        }


        reader.close();
        pw.close();
    }
}
