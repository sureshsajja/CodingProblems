package com.coderevisited.patterns.singleton;


public class SingletonLazyThreadSafe
{
    private SingletonLazyThreadSafe()
    {

    }

    public static SingletonLazyThreadSafe getInstance()
    {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder
    {
        private static final SingletonLazyThreadSafe INSTANCE = new SingletonLazyThreadSafe();
    }
}
