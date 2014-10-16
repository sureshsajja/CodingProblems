package com.coderevisited.patterns.idiom;

public class FinalizerGuardian
{
    private final Object guardian = new Object()
    {
        @Override
        protected void finalize() throws Throwable
        {
            //finalize the outer object
        }
    };
}
