package com.coderevisited.patterns.singleton;

public class SingletonLazyDoubleChecked
{
    private volatile static SingletonLazyDoubleChecked instance;

    private SingletonLazyDoubleChecked()
    {
        // Suppressing creating a new instances
    }

    public static SingletonLazyDoubleChecked getInstance()
    {
        if (instance == null) {
            synchronized (SingletonLazy.class) {
                if (instance == null) {
                    instance = new SingletonLazyDoubleChecked();
                }
            }
        }
        return instance;
    }
}
