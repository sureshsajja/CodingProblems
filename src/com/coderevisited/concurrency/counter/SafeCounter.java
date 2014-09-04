package com.coderevisited.concurrency.counter;

public class SafeCounter
        implements Counter
{
    private int count = 0;

    public synchronized int getCountAndIncrement()
    {
        return count++;
    }

    public static void main(String[] args)
    {
        Counter counter = new SafeCounter();
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
