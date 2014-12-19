package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ICPCTeam
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        String[] knownTopics = new String[N];
        for (int n = 0; n < N; n++) {
            knownTopics[n] = scanner.next();
        }
        int maxKnown = 0;
        int maxKnownGroup = 0;
        for (int i = 0; i < N - 1; i++) {
            String si = knownTopics[i];
            for (int j = i; j < N; j++) {
                String sj = knownTopics[j];
                int known = 0;
                for (int k = 0; k < M; k++) {
                    if (si.charAt(k) == '1' || sj.charAt(k) == '1') {
                        known++;
                    }
                }
                if (known > maxKnown) {
                    maxKnown = known;
                    maxKnownGroup = 1;
                } else if (known == maxKnown) {
                    maxKnownGroup++;
                }
            }
        }

        pw.println(maxKnown);
        pw.println(maxKnownGroup);

        scanner.close();
        pw.close();

    }
}
