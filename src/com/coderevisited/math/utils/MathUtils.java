package com.coderevisited.math.utils;

public class MathUtils
{
    public static double log(int x, int base)
    {
        return Math.log(x) / Math.log(base);
    }

    public static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }


    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }
}
