package com.coderevisited.concurrency.threadpool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerWithThreadPool
{
    private final BlockingQueue<Integer> queue;
    private static final Random rnd = new Random();

    public static void main(String[] args)
    {
        ProducerConsumerWithThreadPool pc = new ProducerConsumerWithThreadPool();
        pc.init();
    }

    public ProducerConsumerWithThreadPool()
    {
        queue = new LinkedBlockingQueue<>(3);
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

    }

    private class Producer implements Runnable
    {
        @Override
        public void run()
        {
            Integer e = rnd.nextInt(100);
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
