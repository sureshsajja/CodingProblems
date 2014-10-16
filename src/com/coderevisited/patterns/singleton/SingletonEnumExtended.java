package com.coderevisited.patterns.singleton;


public enum SingletonEnumExtended
{
    INSTANCE
            {
                public SingletonExpected getInstance()
                {
                    return instance;
                }
            };

    private static final SingletonExpected instance = new SingletonExpected("Dog");

    public abstract SingletonExpected getInstance();
}


