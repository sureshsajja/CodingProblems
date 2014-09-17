package com.spoj;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TEST
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        boolean process = true;
        while (process) {
            int i = scanner.nextInt();
            if (i == 42) {
                process = false;
            }

            if (process) {
                pw.println(i);
            }
        }
        pw.close();
        scanner.close();
    }
}
