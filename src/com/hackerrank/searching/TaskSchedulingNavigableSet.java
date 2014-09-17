package com.hackerrank.searching;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.NavigableSet;
import java.util.Scanner;
import java.util.TreeSet;

public class TaskSchedulingNavigableSet
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        NavigableSet<Job> sortedSet = new TreeSet<Job>();
        long start = System.currentTimeMillis();
        for (int t = 0; t < T; t++) {
            Job task = new Job(t, scanner.nextInt(), scanner.nextInt());
            sortedSet.add(task);

            Job lower = sortedSet.lower(task);
            int elapsedTime = 0;
            int maxOverShoot = 0;
            if (lower != null) {
                elapsedTime = lower.getElapsedTime();
                maxOverShoot = lower.getMaxOverShoot();
            }

            elapsedTime = task.getPendingTime() + elapsedTime;
            task.setElapsedTime(elapsedTime);
            int overShoot = elapsedTime - task.getDeadLine();
            task.setOverShoot(overShoot);
            maxOverShoot = maxOverShoot > overShoot ? maxOverShoot : overShoot;
            task.setMaxOverShoot(maxOverShoot);

            NavigableSet<Job> subset = sortedSet.tailSet(task, false);
            for (Job j : subset) {
                j.setElapsedTime(j.getElapsedTime() + task.getPendingTime());
                j.setOverShoot(j.getOverShoot() + task.getPendingTime());
                maxOverShoot = maxOverShoot > j.getOverShoot() ? maxOverShoot : j.getOverShoot();
                j.setMaxOverShoot(maxOverShoot);
            }


            pw.println(maxOverShoot);
        }

        pw.println((System.currentTimeMillis() - start) / 1000.0);

        scanner.close();
        pw.close();
    }

    private static class Job
            implements Comparable<Job>
    {
        private final int deadLine;
        private final int pendingTime;
        private final int t;
        private int elapsedTime;
        private int overShoot;
        private int maxOverShoot;


        public Job(int t, int deadLine, int pendingTime)
        {
            this.t = t;
            this.deadLine = deadLine;
            this.pendingTime = pendingTime;
        }

        public int getDeadLine()
        {
            return deadLine;
        }

        public int getPendingTime()
        {
            return pendingTime;
        }

        @Override
        public int compareTo(Job that)
        {
            if (this.deadLine == that.deadLine) {
                if (this.pendingTime == that.pendingTime) {
                    if (this.t == that.t) {
                        return 0;
                    } else if (this.t < that.t) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else if (this.pendingTime < that.pendingTime) {
                    return -1;
                } else {
                    return 1;
                }
            } else if (this.deadLine < that.deadLine) {
                return -1;
            } else {
                return 1;
            }
        }

        public int getElapsedTime()
        {
            return elapsedTime;
        }

        public void setElapsedTime(int elapsedTime)
        {
            this.elapsedTime = elapsedTime;
        }

        public int getMaxOverShoot()
        {
            return maxOverShoot;
        }

        public void setMaxOverShoot(int maxOverShoot)
        {
            this.maxOverShoot = maxOverShoot;
        }

        public int getOverShoot()
        {
            return overShoot;
        }

        public void setOverShoot(int overShoot)
        {
            this.overShoot = overShoot;
        }
    }
}
