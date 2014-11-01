package com.coderevisited.backtracking;

/**
 * 1. recursively print permutations by swapping elements
 * 2. after each step back track to previous step
 */
public class Permutations
{
    public static void main(String[] args)
    {
        String str = "ABC";
        printPermutations(str.toCharArray(), 0, str.length() - 1);
    }

    private static void printPermutations(char[] chars, int index, int length)
    {

        if (length == index) {
            System.out.println(chars);
        }

        for (int i = index; i <= length; i++) {
            //swap elements
            swap(chars, i, index);
            printPermutations(chars, index + 1, length);
            //backtrack
            swap(chars, i, index);
        }

    }

    private static void swap(char[] chars, int i, int j)
    {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
