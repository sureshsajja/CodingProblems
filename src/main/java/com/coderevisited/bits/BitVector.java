/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.coderevisited.bits;

/**
 * bit vector with 1 million bits. methods to to set, toggle, unset a particular bit. Memory used  for storing bits :
 * 1million/32 = (32150 + 1) * 4B = 128604B = 128.607KB
 */
public class BitVector
{

    private int[] bitArray;

    public BitVector(long MAX)
    {
        bitArray = new int[(int) (MAX >> 5) + 1];
    }

    public static void main(String[] args)
    {
        BitVector bitVector = new BitVector(1000000L);
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(7834));
        System.out.println(" now setting bit 783  ");
        bitVector.setBit(783);
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(7834));
        bitVector.unSet(783);
        System.out.println(" un setting bit 783 ");
        System.out.println(" bit 783 is set? ---> " + bitVector.isSet(7834));
        bitVector.toggle(783);
        System.out.println(" toggling  bit 783 ");
        System.out.println(" bit 783 is set? ----> " + bitVector.isSet(7834));

    }

    public void setBit(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) | (1 << bit);
    }

    public boolean isSet(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        return ((bitArray[index]) & (1 << bit)) != 0;
    }

    public void toggle(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) ^ (1 << bit);
    }

    public void unSet(long i)
    {
        int index = (int) (i >> 5);
        int bit = (int) (i & 31);
        bitArray[index] = (bitArray[index]) & ~(1 << bit);
    }
}
