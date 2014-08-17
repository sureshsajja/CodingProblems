package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class SherlockAndTheBeast
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = 0;
            StringBuilder sb = new StringBuilder("");
            while (n >= 0) {
                if (n % 3 == 0) {
                    for (int i = 0; i < n; i++) {
                        sb.append("5");
                    }
                    for (int i = 0; i < m; i++) {
                        sb.append("3");
                    }
                    break;
                } else {
                    m += 5;
                    n -= 5;
                }
            }
            if (sb.length() > 0)
                pw.println(sb.toString());
            else {
                pw.println(-1);
            }
        }

        scanner.close();
        pw.close();
    }
}
