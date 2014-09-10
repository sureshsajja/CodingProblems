package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Pairs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            set.add(scanner.nextInt());
        }
        pw.println(findPairs(set, K));

        scanner.close();
        pw.close();

    }

    private static int findPairs(Set<Integer> set, int k)
    {
        int pairs = 0;
        for (int n : set) {
            int toFind = n + k;
            if (set.contains(toFind)) {
                pairs++;
            }
        }
        return pairs;
    }
}
