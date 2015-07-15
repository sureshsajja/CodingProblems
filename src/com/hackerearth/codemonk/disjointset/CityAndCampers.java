
package com.hackerearth.codemonk.disjointset;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class CityAndCampers
{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static int[] parent;
    private static int[] size;
    private static int count;
    private static int maxSize;
    private static int minSize;

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
        maxSize = 1;
        minSize = 1;

        for (int k = 0; k < K; k++) {
            int p = nextInt();
            int q = nextInt();
            union(p - 1, q - 1);
            pw.println(maxSize - minSize);
        }

        reader.close();
        pw.close();

    }

    public static void union(int p, int q)
    {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        if (size[rootP] < size[rootQ]) {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
            if(size[rootQ] > maxSize){
                maxSize = size[rootQ];
            }
        } else {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
            if(size[rootP] > maxSize){
                maxSize = size[rootP];
            }
        }


        count--;
        if (count == 1) {
            minSize = maxSize;
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
