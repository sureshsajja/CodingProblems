package com.hackerrank;

import java.util.Scanner;

public class LetterMystery
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String s = scanner.next();
            convertToPalindrome(s.toCharArray());
        }
    }

    private static void convertToPalindrome(char[] s)
    {
        int moves = 0;
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            moves += Math.abs(s[i] - s[j]);
        }

        System.out.println(moves);
    }
}
