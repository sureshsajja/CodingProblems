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

package com.hackerearth.glydel;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Chotu's father is the owner of a Vada Pav shop. One Sunday, his father takes him to the shop. Father tells him that at the end of the day, Chotu has to give him a list consisting of the names of all the customers on that day who bought Vada Pav(s) from the shop. The list should not have the names of any of the customers being repeated and it should be such that the lexicographically smallest name comes first, ie., the names should be sorted in dictionary order.
 * <p/>
 * As and when a particular customer buys a Vada Pav, Chotu writes down the name of that particular customer. Chotu's initial list is ready, but, he is confused as to how to make the list Father expects from him. Chotu comes to you for help. Your job now is to create the final list, as Father expects from Chotu.
 * <p/>
 * Input :
 * <p/>
 * First line consists of N, the number of names of customers in Chotu's initial list. The next N lines are such that each line consists of a customer's name.
 * <p/>
 * Output :
 * <p/>
 * On the first line, print the total number of names appearing in Chotu's final list. Then print the list such that every customer's name is printed on a new line.
 * <p/>
 * Constraints :
 * <p/>
 * 1<=N<=10^6
 * <p/>
 * 1<=Length of names of customers<=5
 * <p/>
 * Customers' names consist only of lower case English alphabets (a-z).
 * <p/>
 * Note : Some test files contain large data. Use scanf/printf instead of cin/cout .
 * <p/>
 * <p/>
 * Input
 * =====
 * 11
 * babu
 * anand
 * rani
 * aarti
 * nandu
 * rani
 * rani
 * ap
 * anand
 * babu
 * nandu
 * <p/>
 * <p/>
 * Output
 * ======
 * 6
 * aarti
 * anand
 * ap
 * babu
 * nandu
 * rani
 * <p/>
 * <p/>
 * Solution
 * ========
 * 1. Add customer names to a set, removing the dupliactes
 * 2. Sort the array of non duplicate names using 3 way String quick sort or MSD sort.
 * 3. See here for 3 way String quick sort
 * <p/>
 * http://algs4.cs.princeton.edu/51radix/
 */
public class VadaPavList {

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

        Set<String> set = new HashSet<>();

        for (int n = 0; n < N; n++) {
            String s = next();
            set.add(s);
        }

        pw.println(set.size());

        String[] list = set.toArray(new String[set.size()]);
        sort(list);
        for (String s : list) {
            pw.println(s);
        }


        reader.close();
        pw.close();
    }

    private static final int CUTOFF = 15;   // cutoff to insertion sort


    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }


    private static int charAt(String s, int d) {
        assert d >= 0 && d <= s.length();
        if (d == s.length()) return -1;
        return s.charAt(d);
    }


    private static void sort(String[] a, int lo, int hi, int d) {


        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        int lt = lo, gt = hi;
        int v = charAt(a[lo], d);
        int i = lo + 1;
        while (i <= gt) {
            int t = charAt(a[i], d);
            if (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        sort(a, lo, lt - 1, d);
        if (v >= 0) sort(a, lt, gt, d + 1);
        sort(a, gt + 1, hi, d);
    }


    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j - 1], d); j--)
                exch(a, j, j - 1);
    }


    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean less(String v, String w, int d) {
        assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

}
