package com.hackerearth.webengage;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

//todo Not a correct solution
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
            Integer[] jobs = new Integer[N];
            for (int n = 0; n < N; n++) {
                jobs[n] = scanner.nextInt();
            }

            Arrays.sort(jobs, Collections.reverseOrder());
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.add(0);
            pq.add(0);

            for (int n = 0; n < N; n++) {
                int i = pq.poll();
                pq.add(i + jobs[n]);
            }

            boolean canBeDone = true;
            while (!pq.isEmpty()) {
                if (pq.poll() > x) {
                    canBeDone = false;
                    break;
                }
            }

            if (canBeDone) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }

        }


        scanner.close();
        pw.close();
    }
}
