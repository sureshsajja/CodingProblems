package com.coderevisited.strings;

public class PatternSearching
{
    public static void main(String[] args)
    {
        String text = "AAAAAAAAAAAAAAAAAB";
        String pattern = "AAAAB";
        findAllOccurrences(text, pattern);
    }

    private static void findAllOccurrences(String text, String pattern)
    {
        int N = text.length();
        int M = pattern.length();

        for (int i = 0; i <= N - M; i++) {
            int j = 0;
            for (; j < M; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }

            if (j == M) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }
}
