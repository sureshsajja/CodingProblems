package com.hackerearth.vizury;


import java.io.*;
import java.util.StringTokenizer;

import static java.lang.System.in;
import static java.lang.System.out;

public class TraceOfAMatrix
{
    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException
    {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static long nextLong() throws IOException
    {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException
    {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        long T = nextLong();
        for (int t = 0; t < T; t++) {
            long R = nextLong();
            long C = nextLong();
            if (R > C) {
                long temp = R;
                R = C;
                C = temp;
            }
            long sum;
            long nSum = (R * (R + 1)) / 2;
            long nMinus1Sum = ((R - 1) * R) / 2;
            sum = 2 * nSum + C * nMinus1Sum + R * nMinus1Sum;
            pw.println(sum);
        }


        reader.close();
        pw.close();
    }
}
