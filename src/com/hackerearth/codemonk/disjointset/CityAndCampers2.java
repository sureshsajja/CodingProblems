
package com.hackerearth.codemonk.disjointset;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;


public class CityAndCampers2
{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] parent;
    private static int[] size;
    private static int count;


    private static String next() throws IOException
    {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException
    {
        return parseInt(next());
    }

    private static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException
    {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = nextInt();
        int K = nextInt();

        count = N;
        parent = new int[N];
        size = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
            size[i] = 1;
        }


        int diff = 0;
        for (int k = 0; k < K; k++) {
            int p = nextInt();
            int q = nextInt();
            diff = union(p - 1, q - 1, diff);
            if (count == 0) {
                pw.println(0);
            } else {
                pw.println(diff);
            }
        }

        reader.close();
        pw.close();

    }

    public static int union(int p, int q, int cdiff)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return cdiff;
        }

        count--;
        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            int diff = size[rootQ] - size[rootP];
            size[rootQ] += size[rootP];
            return diff;
        } else {
            parent[rootQ] = rootP;
            int diff = size[rootP] - size[rootQ];
            size[rootP] += size[rootQ];
            return diff;
        }
    }

    public static int find(int p)
    {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

}
