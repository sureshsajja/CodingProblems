package com.hackerearth.webengage;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class AmazingTest
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int x = scanner.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(N, Collections.reverseOrder());
            for (int n = 0; n < N; n++) {
                pq.add(scanner.nextInt());
            }
            pq.add(0);
            int time = 0;
            while (true) {
                int val = pq.poll();
                if (val == 0)
                    break;
                int val1 = pq.poll();
                if (val1 == 0) {
                    time += val;
                    break;
                }

                time += val1;
                val -= val1;
                pq.add(val);

            }
            if (time <= x) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }

        }
        scanner.close();
        pw.close();
    }
}
