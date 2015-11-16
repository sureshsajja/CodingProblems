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

package com.hackerearth.target;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RoyAndTrendingTopics
{
    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        int N = scanner.nextInt();
        PriorityQueue<Topic> topics = new PriorityQueue<Topic>();
        for (int i = 0; i < N; i++) {
            int id = scanner.nextInt();
            long score = scanner.nextLong();
            long p = scanner.nextLong() * 50;
            long l = scanner.nextLong() * 5;
            long c = scanner.nextLong() * 10;
            long s = scanner.nextLong() * 20;
            topics.add(new Topic(id, score, p + l + c + s));
        }

        for (int i = 0; i < 5; i++) {
            Topic t = topics.poll();
            pw.println(t.id + " " + t.newScore);
        }

        scanner.close();
        pw.close();
    }

    private static class Topic implements Comparable
    {

        private final int id;
        private final long newScore;
        private final long difference;

        public Topic(int id, long score, long newScore)
        {
            this.id = id;
            this.newScore = newScore;
            this.difference = newScore - score;
        }

        public int compareTo(Object o)
        {
            Topic that = (Topic) o;
            if (this.difference < that.difference) {
                return 1;
            } else if (this.difference > that.difference) {
                return -1;
            } else {
                if (this.id < that.id) {
                    return 1;
                } else if (this.id > that.id) {
                    return -1;
                } else
                    return 0;
            }

        }
    }
}
