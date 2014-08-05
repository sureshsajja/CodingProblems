package com.coderevisited.concurrency;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorUtils
{

    public static ExecutorService singleThreadPoolExecutor()
    {
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService singleThreadPoolExecutor(int queueSize)
    {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize));
    }


    public static ExecutorService singleThreadPoolExecutor(String processName)
    {
        return Executors.newSingleThreadExecutor(new DefaultThreadFactory(processName));
    }

    public static ExecutorService singleThreadPoolExecutor(int queueSize, String processName)
    {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize),
                new DefaultThreadFactory(processName));
    }

    public static ExecutorService newCachedThreadPool(String processName)
    {
        return Executors.newCachedThreadPool(new DefaultThreadFactory(processName));
    }

    public static class DefaultThreadFactory
            implements ThreadFactory
    {
        final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        public DefaultThreadFactory(String processName)
        {
            this.namePrefix = processName;
        }

        @Override
        public Thread newThread(Runnable r)
        {
            Thread t = new Thread(r, namePrefix + threadNumber.getAndIncrement());
            t.setDaemon(true);
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}
