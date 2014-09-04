package com.coderevisited.concurrency.counter;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter
        implements Counter
{
    private AtomicInteger count = new AtomicInteger();

    @Override
    public int getCountAndIncrement()
    {
        return count.getAndIncrement();
    }

    public static void main(String[] args)
    {
        Counter counter = new AtomicCounter();
        Thread a = new Thread(new CounterRunnable(counter));
        a.start();
        Thread b = new Thread(new CounterRunnable(counter));
        b.start();
        Thread c = new Thread(new CounterRunnable(counter));
        c.start();
        Thread d = new Thread(new CounterRunnable(counter));
        d.start();
    }
}
