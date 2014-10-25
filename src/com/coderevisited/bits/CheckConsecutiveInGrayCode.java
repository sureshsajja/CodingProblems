package com.coderevisited.bits;

public class CheckConsecutiveInGrayCode
{
    public static void main(String[] args)
    {
        int a = 0x00;
        int b = 0x80;
        if (Math.abs(GrayCodeConversion.binaryToGrayCode(a) - GrayCodeConversion.binaryToGrayCode(b)) == 1)
            System.out.println("consecutive");
        else
            System.out.println("Not consecutive");
    }
}
