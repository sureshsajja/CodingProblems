package com.hackerearth.mayhem15;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 31/05/15.
 */

/**
 * https://www.hackerearth.com/may-hem-15/algorithm/perfect-baseline/
 */
public class PerfectBaseline {

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

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {

            int N = nextInt();
            int K = nextInt();

            List[] lists = new List[K];
            for (int k = 0; k < K; k++) {

                lists[k] = new ArrayList<>();
            }

            for (int n = 0; n < N; n++) {
                char[] chars = next().toCharArray();
                for (int k = 0; k < K; k++) {

                    lists[k].add(chars[k]);
                }
            }

            char[] required = new char[K];
            for (int k = 0; k < K; k++) {
                List<Character> _list = lists[k];
                Collections.sort(_list);
                int n = getMid(_list.size());
                required[k] = _list.get(n - 1);
            }
            pw.println(required);
        }
        reader.close();
        pw.close();
    }

    private static int getMid(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return (n + 1) / 2;
        }
    }
}
