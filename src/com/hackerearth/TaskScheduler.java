package com.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * For a task i, it takes one day to start a job, and ki days to complete.
 * For given n tasks, schedule it effectively such that it takes min days to complete
 * <p/>
 * input:
 * 2 (No of tasks)
 * 3
 * 1
 * <p/>
 * output:
 * 4
 */
public class TaskScheduler {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int K = scanner.nextInt();
        Integer[] queue = new Integer[K];

        for (int i = 0; i < K; i++) {
            queue[i] = scanner.nextInt();
        }

        Arrays.sort(queue, Collections.reverseOrder());


        int time = 0;
        int pendingTime = 0;

        for (Integer i : queue) {
            if (pendingTime > 0)
                pendingTime--;
            time = time + 1;
            if (pendingTime < i)
                pendingTime = i;
        }


        System.out.println(time + pendingTime);
    }
}
