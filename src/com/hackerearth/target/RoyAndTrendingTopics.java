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
