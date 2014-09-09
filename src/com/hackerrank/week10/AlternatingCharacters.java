package com.hackerrank.week10;


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
            char[] array = scanner.next().toCharArray();

            char prev = array[0];
            int toDelete = 0;
            for (int i = 1; i < array.length; i++) {
                if (array[i] == prev) {
                    toDelete++;
                } else {
                    prev = array[i];
                }
            }
            pw.println(toDelete);
        }

        scanner.close();
        pw.close();
    }
}
