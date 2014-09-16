package com.coderevisited.rmq;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * http://www.topcoder.com/tc?d1=tutorials&d2=lowestCommonAncestor&module=Static
 */
public class TrivialRMQ
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
        }

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int min = A;
            for (int i = A + 1; i <= B; i++) {
                if (array[min] > array[i]) {
                    min = i;
                }
            }
            pw.println(min);
        }

        scanner.close();
        pw.close();
    }
}
