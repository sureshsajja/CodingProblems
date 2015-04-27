package com.spoj;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Peter wants to generate some prime numbers for his cryptosystem. Help him! Your task is to generate all prime numbers between two given numbers!
 * <p/>
 * Input
 * <p/>
 * The input begins with the number t of test cases in a single line (t<=10). In each of the next t lines there are two numbers m and n (1 <= m <= n <= 1000000000, n-m<=100000) separated by a space.
 * <p/>
 * Output
 * <p/>
 * For every test case print all prime numbers p such that m <= p <= n, one number per line, test cases separated by an empty line.
 * <p/>
 * Example
 * <p/>
 * Input
 * =====
 * 2
 * 1 10
 * 3 5
 * <p/>
 * Output
 * ======
 * 2
 * 3
 * 5
 * 7
 * <p/>
 * 3
 * 5*
 */
public class PrimalityTest {

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

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            int a = nextInt();
            int b = nextInt();
            for (int i = a; i <= b; i++) {
                if (isPrime(i)) {
                    pw.println(i);
                }
            }
            pw.println();
        }
        reader.close();
        pw.close();

    }

    public static boolean isPrime(int n) {
        if (n <= 3) {
            return n > 1;
        } else if (n % 2 == 0 || n % 3 == 0) {
            return false;
        } else {
            double sqrtN = Math.floor(Math.sqrt(n));
            for (int i = 5; i <= sqrtN; i += 6) {
                if (n % i == 0 || n % (i + 2) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
