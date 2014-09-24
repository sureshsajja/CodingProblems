package com.coderevisited.singleton;

public class SingletonEarly
{
    private final static SingletonEarly instance = new SingletonEarly();

    private SingletonEarly()
    {

    }

    public static SingletonEarly getInstance()
    {
        return instance;
    }
}
