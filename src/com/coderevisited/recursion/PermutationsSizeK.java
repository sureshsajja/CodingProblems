package com.coderevisited.recursion;

public class PermutationsSizeK
{
    public static void main(String[] args)
    {
        String s = "abcde";
        printPermutations(s, "", 3);
    }

    private static void printPermutations(String s, String prefix, int K)
    {
        if (prefix.length() == K) {
            System.out.println(prefix);
        }
        for (int i = 0; i < s.length(); i++) {
            printPermutations(s.substring(0, i) + s.substring(i + 1, s.length()), prefix + s.charAt(i), K);
        }
    }
}
