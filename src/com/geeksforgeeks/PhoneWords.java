package com.geeksforgeeks;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneWords
{
    private static final String[] words = new String[]{"", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            char[] chars = scanner.next().toCharArray();
            int[] number = new int[chars.length];
            for (int i = 0; i < chars.length; i++) {
                number[i] = chars[i] - '0';
            }
            char[] result = new char[chars.length];
            printWords(number, 0, result, pw);
            pw.println();
        }


        scanner.close();
        pw.close();
    }

    private static void printWords(int[] number, int current, char[] result, PrintWriter pw)
    {
        if (current == number.length) {
            pw.print(result);
            pw.print(" ");
            return;
        }

        if (number[current] == 0 || number[current] == 1) {
            printWords(number, current + 1, result, pw);
        }

        for (int i = 0; i < words[number[current]].length(); i++) {
            result[current] = words[number[current]].charAt(i);
            printWords(number, current + 1, result, pw);
        }

    }


}
