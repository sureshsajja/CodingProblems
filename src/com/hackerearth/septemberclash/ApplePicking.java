package com.hackerearth.septemberclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//todo Not a correct solution
public class ApplePicking
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();

            Long[] array = new Long[N];

            long sum = 0;
            for (int n = 0; n < N; n++) {
                array[n] = scanner.nextLong();
                sum += array[n];
            }

            Arrays.sort(array, Collections.reverseOrder());
            PriorityQueue<Long> pq = new PriorityQueue<Long>();
            pq.add(0L);
            pq.add(0L);
            pq.add(0L);

            for (int n = 0; n < N; n++) {
                long i = pq.poll();
                pq.add(i + array[n]);
            }

            while (!pq.isEmpty()) {
                pw.print(pq.poll() + " ");
            }
            pw.println();
        }

        scanner.close();
        pw.close();
    }
}
