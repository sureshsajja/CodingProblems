package com.hackerearth.januaryeasy15;

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 12/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/ikshu-and-his-machine-gun/
 */
public class IkshuAndHisMachineGun {

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
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(nextInt());
        }

        Collections.sort(list);

        int diff = 0;
        while (!list.isEmpty()) {
            int removed = list.remove(0);
            pw.print(removed - diff);
            pw.print(" ");
            diff++;
        }
        pw.println();


        reader.close();
        pw.close();
    }
}
