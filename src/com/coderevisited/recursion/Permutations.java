package com.coderevisited.recursion;

public class Permutations
{

    public static void main(String[] args)
    {

        String s = "abcd";
        printPermutations(s, "");

    }

    private static void printPermutations(String s, String prefix)
    {
        if (s.length() == 0) {
            System.out.println(prefix);
        }

        for (int i = 0; i < s.length(); i++) {
            printPermutations(s.substring(0, i) + s.substring(i + 1, s.length()), prefix + s.charAt(i));
        }

    }
}
