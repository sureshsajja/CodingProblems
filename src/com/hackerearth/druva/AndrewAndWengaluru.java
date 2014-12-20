package com.hackerearth.druva;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AndrewAndWengaluru
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[N];
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextInt();
            }
            pw.println(findWaterCollected(array));
        }

        scanner.close();
        pw.close();
    }


    private static int findWaterCollected(int[] array)
    {

        if (array.length < 3)
            return 0;

        long count = 0;
        int maxLeft = 0;
        int k = 1;
        int maxRight = 2;
        while (maxLeft < array.length && k < array.length && maxRight < array.length) {
            for (int i = maxRight + 1; i < array.length; i++) {
                if (array[i] > array[maxRight]) {
                    maxRight = i;
                }
            }

            while (k < maxRight) {
                if (array[k] < array[maxLeft] && array[k] < array[maxRight]) {
                    int min = array[maxLeft] < array[maxRight] ? array[maxLeft] : array[maxRight];
                    count = (count + min - array[k]) % 1000000007;
                }
                if (array[k] > array[maxLeft]) {
                    maxLeft = k;
                }
                k++;
            }
            maxLeft = maxRight;
            k = maxLeft + 1;
            maxRight = maxLeft + 2;
        }

        return (int) count;

    }
}
