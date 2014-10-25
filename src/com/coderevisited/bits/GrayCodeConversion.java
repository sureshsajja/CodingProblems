package com.coderevisited.bits;

public class GrayCodeConversion
{

    public static void main(String[] args)
    {
        int n = binaryToGrayCode(10);
        System.out.println("binary to gray " + n);
        System.out.println("gray to binary " + grayToBinary(n));
    }

    public static int binaryToGrayCode(int n)
    {
        return (n >> 1) ^ n;
    }

    public static int grayToBinary(int n)
    {
        for (int mask = n >> 1; mask != 0; mask = mask >> 1) {
            n = n ^ mask;
        }
        return n;
    }
}
