package com.coderevisited.math.prime;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class PrimeFactors {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static long nextLong() throws IOException {
        return Long.parseLong(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        long N = nextLong();
        List<Long> primeFactors = calculatePrimeFactors(N);

        pw.println(primeFactors);

        reader.close();
        pw.close();

    }

    private static List<Long> calculatePrimeFactors(long n) {

        List<Long> factors = new ArrayList<>();

        while (n % 2 == 0) {
            n = n / 2;
            factors.add(2L);
        }

        while (n % 3 == 0) {
            n = n / 3;
            factors.add(3L);
        }

        for (long i = 5; i <= Math.sqrt(n); i += 6) {
            while (n % i == 0) {
                factors.add(i);
                n = n / i;
            }
            while (n % (i + 2) == 0) {
                factors.add(i + 2);
                n = n / (i + 2);
            }
        }
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }

}
