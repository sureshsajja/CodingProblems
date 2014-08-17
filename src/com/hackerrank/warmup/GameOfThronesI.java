package com.hackerrank.warmup;


import java.util.Scanner;

public class GameOfThronesI
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[] hist = new int[26];
        for (char c : input.toCharArray()) {
            hist[c - 'a']++;
        }

        boolean oddPermitted = false;
        if ((input.length() & 1) != 0) {
            oddPermitted = true;
        }
        boolean found = true;
        for (int i = 0; i < 26; i++) {
            boolean isOdd = (hist[i] & 1) != 0;
            if (isOdd && oddPermitted) {
                oddPermitted = false;
            } else if (isOdd) {
                found = false;
                break;
            }
        }

        if (found) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
