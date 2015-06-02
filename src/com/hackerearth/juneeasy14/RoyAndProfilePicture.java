package com.hackerearth.juneeasy14;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/roy-and-profile-picture/
 */
public class RoyAndProfilePicture {

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

        int L = nextInt();
        int N = nextInt();
        for (int n = 0; n < N; n++) {
            int W = nextInt();
            int H = nextInt();


            if (W < L || H < L) {
                pw.println("UPLOAD ANOTHER");
            } else if (W == L && H == L) {
                pw.println("ACCEPTED");
            } else if (W == H) {
                pw.println("ACCEPTED");
            } else {
                pw.println("CROP IT");
            }
        }


        reader.close();
        pw.close();
    }
}
