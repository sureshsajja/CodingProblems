package com.hackerearth.craftsvilla;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 12-06-2016
 */

/**
 * https://www.hackerearth.com/problem/algorithm/lucky-numbers-20/
 */
public class LuckyNumbers {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static final long MAX = (long) Math.pow(10, 18);
    private static final int MOD = 1000000007;

    private static Map<Long, Long> map = new TreeMap<>();

    /**
     * 2+1
     4+1 4+2
     8+1 8+2 8+4
     */
    static {
        long prevSum = 0L;
        //start from every power of 2
        for (long i = 2; i <= MAX; i <<= 1) {
            long sum = 0L;
            long j = i >> 1;
            //Calculate the sum pow+1, pow+2 ... pow+(pow/2)....
            while (j > 0) {
                sum += i + j;
                sum %= MOD;
                j >>= 1;
            }
            //attach that sum to next power .. capturing ...sum of all number with 2 set bits before that power
            long key = i << 1;
            sum += prevSum;
            sum %= MOD;
            prevSum = sum;
            map.put(key, sum);
        }
    }

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            long N = nextLong();
            long nearest = 0;
            long sum = 0;
            for (long l : map.keySet()) {
                if (l <= N) {
                    nearest = l;
                    sum = map.get(l);
                } else {
                    break;
                }
            }

            //we know where to start.. Calculate the sum pow+1, pow+2 ... pow+(pow/2).... up to N
            long j = 1;
            long max = nearest >> 1;
            while (j <= max && nearest + j <= N) {
                sum += nearest + j;
                sum %= MOD;
                j <<= 1;
            }

            if (N == 3) {
                pw.println(3);
            } else
                pw.println(sum);
        }

        pw.close();
        reader.close();

    }
}
