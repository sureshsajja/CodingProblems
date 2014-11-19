package com.coderevisited.concurrency.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerWithThreadPool
{
    private static AtomicInteger rnd = new AtomicInteger(0);
    private final BlockingQueue<Integer> queue;

    public ProducerConsumerWithThreadPool()
    {
        queue = new LinkedBlockingQueue<>(3);
    }

    public static void main(String[] args)
    {
        ProducerConsumerWithThreadPool pc = new ProducerConsumerWithThreadPool();
        pc.init();
    }

    private void init()
    {
        ThreadPool pool = new ThreadPool(2);
        for (int i = 0; i < 100; i++) {
            pool.addTask(new Producer());
            pool.addTask(new Producer());
            pool.addTask(new Producer());

            pool.addTask(new Consumer());
            pool.addTask(new Consumer());
            pool.addTask(new Consumer());
        }
        pool.shutdown();
    }

    private class Producer implements Runnable
    {
        @Override
        public void run()
        {
            Integer e = rnd.incrementAndGet();
            System.out.println("Inserting Element " + e);
            try {
                queue.put(e);
                Thread.sleep(1000);
            } catch (InterruptedException e2) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private class Consumer implements Runnable
    {
        @Override
        public void run()
        {
            try {
                System.out.println("Removing Element " + queue.take());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
