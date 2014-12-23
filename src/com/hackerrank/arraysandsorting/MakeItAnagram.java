package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MakeItAnagram
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        String A = scanner.next();
        String B = scanner.next();

        int[] hist = new int[256];

        for (char c : A.toCharArray()) {
            hist[c]++;
        }

        int count = 0;
        for (char c : B.toCharArray()) {
            if (hist[c] > 0) {
                hist[c]--;
            } else {
                count++;
            }
        }

        for (int i : hist) {
            count += i;
        }
        pw.println(count);

        scanner.close();
        pw.close();

    }
}
