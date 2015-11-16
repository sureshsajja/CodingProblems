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
