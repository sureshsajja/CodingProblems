package com.coderevisited.concurrency.visibility;

import java.util.concurrent.atomic.AtomicInteger;

public class NoVisibility
{
    private static AtomicInteger number = new AtomicInteger();
    private static boolean ready;

    public static void main(String[] args)
    {
        Thread a = new Thread(new Writer());
        a.start();
        Thread b = new Thread(new Reader());
        b.start();
    }

    private static class Reader
            implements Runnable
    {
        @Override
        public void run()
        {
            while (!ready) {
                Thread.yield();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println("Read value as : " + number.get());
            }
        }
    }

    private static class Writer
            implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Writing value as : " + number.getAndIncrement());
            ready = true;
            for (int i = 0; i < 20; i++) {
                System.out.println("Writing value as : " + number.getAndIncrement());
            }
        }
    }
}
