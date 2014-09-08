package com.coderevisited.concurrency.counter;

public class NonSafeCounter
        implements Counter
{
    private int count = 0;

    public static void main(String[] args)
    {
        NonSafeCounter counter = new NonSafeCounter();
        Thread a = new Thread(new CounterRunnable(counter));
        a.start();
        Thread b = new Thread(new CounterRunnable(counter));
        b.start();
        Thread c = new Thread(new CounterRunnable(counter));
        c.start();
        Thread d = new Thread(new CounterRunnable(counter));
        d.start();
    }

    public int getCountAndIncrement()
    {
        return count++;
    }
}
