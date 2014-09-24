package com.coderevisited.singleton;

public class SingletonEarly
{
    private final static SingletonEarly instance = new SingletonEarly();

    private SingletonEarly()
    {

    }

    public SingletonEarly getInstance()
    {
        return instance;
    }
}
