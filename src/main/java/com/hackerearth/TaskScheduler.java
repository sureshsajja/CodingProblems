/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.hackerearth;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * For a task i, it takes one day to start a job, and ki days to complete. For given n tasks, schedule it effectively
 * such that it takes min days to complete. Only one task can be started in a day. Started jobs can go on parallel.
 * <p/>
 * input: 2 (No of tasks) 3 1
 * <p/>
 * output: 4
 */
public class TaskScheduler
{

    public static void main(String[] args) throws Exception
    {

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
            if (pendingTime > 0) {
                pendingTime--;
            }
            time = time + 1;
            if (pendingTime < i) {
                pendingTime = i;
            }
        }


        System.out.println(time + pendingTime);
    }
}
