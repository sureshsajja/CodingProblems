package com.coderevisited.concurrency;


import java.util.concurrent.*;

public class ExecutorUtils {

    public static ExecutorService singleThreadPoolExecutor() {
        return Executors.newSingleThreadExecutor();
    }

    public static ExecutorService singleThreadPoolExecutor(int queueSize) {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize));
    }


    public static ExecutorService singleThreadPoolExecutor(String processName) {
        return Executors.newSingleThreadExecutor(new DefaultThreadFactory(processName));
    }

    public static ExecutorService singleThreadPoolExecutor(int queueSize, String processName) {
        return new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(queueSize), new DefaultThreadFactory(processName));
    }

    public static class DefaultThreadFactory implements ThreadFactory {

        private final String processName;

        public DefaultThreadFactory(String processName) {
            this.processName = processName;
            Executors.defaultThreadFactory();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r, processName);
            t.setDaemon(true);
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

}
