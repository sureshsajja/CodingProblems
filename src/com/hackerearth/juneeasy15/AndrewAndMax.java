package com.hackerearth.juneeasy15;

import java.io.*;
import java.text.DecimalFormat;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Author : Suresh
 * Date : 02/06/15.
 */
public class AndrewAndMax {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;

    private static DecimalFormat df = new DecimalFormat("#.00");


    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    private static double nextDouble() throws IOException {
        return Double.parseDouble(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            double X = nextDouble();
            double Y = nextDouble();
            double Z = nextDouble();
            double A = calculateA(X, Y, Z);
            double B = calculateB(X, Y, Z);
            double C = calculateC(X, Y, Z);
            pw.println(df.format(calculateArea(A, B, C)));
        }


        reader.close();
        pw.close();
    }


    private static double calculateA(double x, double y, double z) {
        return (x - y + z) / 2;
    }

    private static double calculateB(double x, double y, double z) {
        return (x + y - z) / 2;
    }

    private static double calculateC(double x, double y, double z) {
        return (-x + y + z) / 2;
    }

    private static double calculateArea(double A, double B, double C) {
        return 2 * (A * B + B * C + C * A);
    }

}
