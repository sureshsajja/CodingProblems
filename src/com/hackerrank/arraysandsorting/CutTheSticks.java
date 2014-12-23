package com.hackerrank.arraysandsorting;


import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CutTheSticks
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            array[i] = scanner.nextInt();
            if (array[i] < min) {
                min = array[i];
            }
        }

        int count = N;
        int nextMin = Integer.MAX_VALUE;
        while (count > 0) {
            pw.println(count);
            for (int i = 0; i < N; i++) {
                if (array[i] > 0) {
                    array[i] = array[i] - min;
                    if (array[i] == 0) {
                        count--;
                    } else {
                        if (array[i] < nextMin) {
                            nextMin = array[i];
                        }
                    }
                }
            }
            min = nextMin;
            nextMin = Integer.MAX_VALUE;
        }


        scanner.close();
        pw.close();

    }
}
