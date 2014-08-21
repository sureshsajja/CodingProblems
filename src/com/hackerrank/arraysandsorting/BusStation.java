package com.hackerrank.arraysandsorting;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BusStation
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int N = scanner.nextInt();
        int[] array = new int[N];
        int sum = 0;
        int max = 0;
        for (int n = 0; n < N; n++) {
            array[n] = scanner.nextInt();
            sum += array[n];
            max = max > array[n] ? max : array[n];
        }

        Set<Integer> set = new TreeSet<Integer>();
        set.add(sum);

        for (int i = 2; (sum / i) >= max; i++) {
            if ((sum % i) == 0) {
                int presentSum = sum / i;
                int count = 0;
                for (int j = 0; j < N; j++) {
                    count += array[j];
                    if (count == presentSum) {
                        count = 0;
                    }
                    if (count > presentSum) {
                        break;
                    }
                }
                if (count == 0) {
                    set.add(presentSum);
                }
            }
        }

        for (Integer i : set) {
            pw.print(i);
            pw.print(" ");
        }


        scanner.close();
        pw.close();

    }
}
