package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AlternatingCharacters
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String s = scanner.next();
            char lastChar = s.charAt(0);
            int toDelete = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == lastChar) {
                    toDelete++;
                } else {
                    lastChar = s.charAt(i);
                }
            }
            pw.println(toDelete);
        }

        scanner.close();
        pw.close();

    }
}
