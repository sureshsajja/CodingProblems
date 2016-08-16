package com.coderevisited.math.fib;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 01-07-2016
 */
public class FindFib {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static int MOD = 1000000000 + 7;

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

        int A = nextInt();
        int B = nextInt();
        int N = nextInt();

        pw.println(solution(A, B, N));
        pw.close();
        reader.close();
    }

    public static int solution(int A, int B, int N) {
        if (N == 0) {
            return A;
        } else if (N == 1) {
            return B;
        } else
            return (int) ((count(N - 1) * A % MOD + count(N) * B % MOD) % MOD);

    }

    private static long count(long n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        long[][] M = new long[][] {{1, 1}, {1, 0}};
        raiseMtoPower(M, n - 1);
        return (M[0][0]);
    }

    private static void raiseMtoPower(long[][] m, long k) {
        if (k == 0 || k == 1 || k < 0) {
            return;
        }
        long[][] f = new long[][] {{1, 1}, {1, 0}};

        raiseMtoPower(m, k >> 1);
        multiplyMN(m, m);

        if ((k & 1) == 1) {
            multiplyMN(m, f);
        }
    }

    private static void multiplyMN(long[][] M, long[][] N) {
        long[][] L = new long[2][2];
        L[0][0] = ((M[0][0] * N[0][0]) % MOD + (M[0][1] * N[1][0]) % MOD) % MOD;
        L[0][1] = ((M[0][0] * N[0][1]) % MOD + (M[0][1] * N[1][1]) % MOD) % MOD;
        L[1][0] = ((M[1][0] * N[0][0]) % MOD + (M[1][1] * N[1][0]) % MOD) % MOD;
        L[1][1] = ((M[1][0] * N[0][1]) % MOD + (M[1][1] * N[1][1]) % MOD) % MOD;
        for (int i = 0; i < 2; i++) {
            System.arraycopy(L[i], 0, M[i], 0, 2);
        }
    }
}
