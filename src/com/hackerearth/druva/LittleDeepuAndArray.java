package com.hackerearth.druva;


import java.io.*;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;


/**
 * Author : Suresh
 * Date : 05/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/little-deepu-and-array/
 */
public class LittleDeepuAndArray {

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

        int M = nextInt();
        for (int m = 0; m < M; m++) {
            int x = nextInt();
            for (int i = 0; i < N; i++) {
                if (array[i] > x) {
                    array[i]--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            pw.print(array[i] + " ");
        }
        pw.println();


        reader.close();
        pw.close();
    }
}
