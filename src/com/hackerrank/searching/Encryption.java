package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encryption
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String s = scanner.next();
        char[] array = s.toCharArray();
        double sqrt = Math.sqrt(s.length());
        int w = (int) Math.floor(Math.round(sqrt));
        int h = (int) Math.ceil(sqrt);

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (i + j * h <= s.length() - 1) {
                    pw.print(array[i + j * h]);
                }
            }
            pw.print(" ");
        }

        scanner.close();
        pw.close();
    }
}
