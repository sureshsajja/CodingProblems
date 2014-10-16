package com.coderevisited.patterns.singleton;

public class SingletonLazy
{
    private static SingletonLazy instance;

    private SingletonLazy()
    {
        // Suppressing creating a new instances
    }

    public static SingletonLazy getInstance()
    {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}
