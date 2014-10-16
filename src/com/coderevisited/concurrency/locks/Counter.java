package com.coderevisited.concurrency.locks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter
{
    private int count = 0;

    private static final Lock lock = new ReentrantLock();

    public int incrementAndGetCount()
    {

        lock.lock();
        try {
            return ++count;
        } finally {
            lock.unlock();
        }
    }


    public static void main(String[] args)
    {
        final Counter counter = new Counter();
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println(Thread.currentThread().getName() + " : count :" + counter.incrementAndGetCount());
            }
        };

        for (int i = 0; i < 100; i++) {
            new Thread(r, "T" + i).start();
        }
    }
}
