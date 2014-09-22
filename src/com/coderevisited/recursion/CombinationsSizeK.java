package com.coderevisited.recursion;

public class CombinationsSizeK
{
    public static void main(String[] args)
    {
        String s = "abcde";
        printCombinations(s, "", 3);

        int[] array = new int[]{3, 4, 5, 6, 7};
        printNumbers(0, array, 0, new int[3]);
    }

    private static void printNumbers(int start, int[] array, int K, int[] result)
    {
        if (K == 3) {
            for (int i = 0; i < K; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < array.length; i++) {
            result[K] = array[i];
            printNumbers(i + 1, array, K + 1, result);
        }
    }

    private static void printCombinations(String s, String prefix, int K)
    {
        if (prefix.length() == K) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            printCombinations(s.substring(i + 1, s.length()), prefix + s.charAt(i), K);
        }
    }
}
