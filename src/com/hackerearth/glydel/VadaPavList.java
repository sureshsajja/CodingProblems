package com.hackerearth.glydel;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class VadaPavList
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        Set<String> set = new TreeSet<>();

        for (int n = 0; n < N; n++) {
            String s = scanner.next();
            set.add(s);
        }

        pw.println(set.size());
        for (String s : set) {
            pw.println(s);
        }

        pw.close();
        scanner.close();
    }
}
