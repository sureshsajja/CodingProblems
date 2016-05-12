package com.coderevisited.math.prime;

import com.coderevisited.math.utils.Modulo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 09-05-2016
 */
public class PrimalityTest {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
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

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int p = nextInt();
            pw.println(testFermat(p, 20));
        }

        pw.close();
        reader.close();

    }

    private static boolean testFermat(int p, int iterations) {
        Random rand = new Random();
        if (p <= 1)
            return false;
        for (int j = 0; j < iterations; j++) {
            int number = rand.nextInt() % (p - 1) + 1;
            if (Modulo.calculateModulo(number, p - 1, p) != 1) {
                return false;
            }
        }
        return true;
    }
}
