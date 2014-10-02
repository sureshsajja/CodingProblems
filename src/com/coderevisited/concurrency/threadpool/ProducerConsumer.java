package com.coderevisited.concurrency.threadpool;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumer
{
    private final BlockingQueue<Integer> queue;
    private static final Random rnd = new Random();

    public static void main(String[] args)
    {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        producerConsumer.init();
    }

    public ProducerConsumer()
    {
        queue = new LinkedBlockingQueue<>(3);
    }

    public void init()
    {
        for (int i = 0; i < 100; i++) {
            new Thread(new Producer(), "Producer-1 of iteration " + i).start();
            new Thread(new Producer(), "Producer-2 of iteration " + i).start();
            new Thread(new Producer(), "Producer-3 of iteration " + i).start();

            new Thread(new Consumer(), "Consumer-1 of iteration " + i).start();
            new Thread(new Consumer(), "Consumer-2 of iteration " + i).start();
            new Thread(new Consumer(), "Consumer-3 of iteration " + i).start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
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
