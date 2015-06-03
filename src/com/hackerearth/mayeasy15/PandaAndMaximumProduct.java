package com.hackerearth.mayeasy15;

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */

/**
 * https://www.hackerearth.com/problem/algorithm/panda-and-maximum-product/
 */
public class PandaAndMaximumProduct {


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
        List<Long> positives = new ArrayList<>();
        List<Long> negatives = new ArrayList<>();
        StringTokenizer _tokenizer = new StringTokenizer(reader.readLine());
        while(_tokenizer.hasMoreElements()){
          long n =   Long.parseLong(_tokenizer.nextToken());
            if (n < 0) {
                negatives.add(n * -1);
            } else {
                positives.add(n);
            }
        }

        Collections.sort(positives);
        Collections.sort(negatives);

        BigInteger pos = getMaxProductWithTwo(positives);
        BigInteger neg = getMaxProductWithTwo(negatives);

        if (pos.compareTo(neg) == 1) {
            pw.println(pos);
        } else {
            pw.println(neg);
        }

        reader.close();

        pw.close();
    }


    private static BigInteger getMaxProductWithTwo(List<Long> list) {


        if (list.size() > 1) {
            long one = list.get(list.size() - 1);
            long two = list.get(list.size() - 2);
            return BigInteger.valueOf(one).multiply(BigInteger.valueOf(two));
        }
        return BigInteger.ZERO;
    }
}
