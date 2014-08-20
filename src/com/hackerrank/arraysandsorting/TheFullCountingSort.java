package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class TheFullCountingSort
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        String[] stringArray = new String[N];
        int[] hist = new int[100];
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
            stringArray[n] = scanner.next();
            hist[array[n]]++;
        }

        for (int i = 0; i < hist.length; i++) {
            for (int j = 0; j < N && hist[i] != 0; j++) {
                if (array[j] == i) {
                    if ((j + 1) > N >> 1)
                        pw.print(stringArray[j]);
                    else
                        pw.print("-");
                    pw.print(" ");
                    hist[i]--;
                }
            }
        }


        scanner.close();
        pw.close();
    }
}
