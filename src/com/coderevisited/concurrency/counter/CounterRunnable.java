package com.coderevisited.concurrency.counter;

public class CounterRunnable
        implements Runnable
{
    private final Counter counter;

    public CounterRunnable(Counter counter)
    {
        this.counter = counter;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20; i++) {
            System.out.println(Thread.currentThread().getName() + " count:" + counter.getCountAndIncrement());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
