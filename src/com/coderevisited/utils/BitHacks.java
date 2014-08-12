package com.coderevisited.utils;

public class BitHacks
{
    public static boolean ifPowOfTwo(int n)
    {
        return n > 0 && (n & n - 1) == 0;
    }

    public static int divideByTwo(int n)
    {
        return n >> 1;
    }

    public static int highestOneBit(int i)
    {
        i |= (i >> 1);
        i |= (i >> 2);
        i |= (i >> 4);
        i |= (i >> 8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }
}
