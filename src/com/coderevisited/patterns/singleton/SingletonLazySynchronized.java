package com.coderevisited.patterns.singleton;

public class SingletonLazySynchronized
{
    private static SingletonLazySynchronized instance;

    private SingletonLazySynchronized()
    {

    }

    public static synchronized SingletonLazySynchronized getInstance()
    {
        if (instance == null)
            instance = new SingletonLazySynchronized();
        return instance;
    }
}
