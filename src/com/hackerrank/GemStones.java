package com.hackerrank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GemStones
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] hist = new int[26];
        for (int n = 0; n < N; n++) {
            String s = scanner.next();

            //Remove duplicates
            Set<Character> set = new HashSet<Character>(26);

            for (char c : s.toCharArray()) {
                set.add(c);
            }

            //build histogram
            for (Character c : set) {
                hist[c - 'a']++;
            }

        }

        int result = 0;
        //visit histogram
        for (int i = 0; i < 26; i++) {
            if (hist[i] == N) {
                result++;
            }
        }

        System.out.println(result);
    }
}
