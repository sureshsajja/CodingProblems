package com.hackerearth.iitkgp;

import java.io.*;
import java.util.*;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 03/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/day-5-recursion/
 */
public class HellOfADay {

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
        List<Integer> even = new LinkedList<>();
        List<Integer> odd = new LinkedList<>();
        for (int n = 0; n < N; n++) {
            int i = nextInt();
            if (i % 2 == 0) {
                even.add(i);
            } else {
                odd.add(i);
            }
        }

        Collections.sort(even);
        Collections.sort(odd, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (Integer i : even) {
            pw.print(i + " ");
        }

        pw.println(" ");
        for (Integer i : odd) {
            pw.print(i + " ");
        }


        reader.close();
        pw.close();
    }
}
