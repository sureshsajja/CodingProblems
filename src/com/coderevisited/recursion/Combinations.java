package com.coderevisited.recursion;

public class Combinations
{

    public static void main(String[] args)
    {
        String s = "abc";
        printCombinations(s, "");
    }

    private static void printCombinations(String s, String prefix)
    {
        if (prefix.length() > 0)
            System.out.println(prefix);

        for (int i = 0; i < s.length(); i++) {
            printCombinations(s.substring(i + 1, s.length()), prefix + s.charAt(i));
        }

    }

}
