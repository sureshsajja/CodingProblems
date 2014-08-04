package com.coderevisited.utils;

/**
 * Implementation of Sieve Of Eratosthenes.. Generating prime numbers up to 1 billion using wheel_2357
 */
public class SieveOfEratosthenes
{

    private static final int MAX = 1000000000;


    public static void main(String[] args)
    {

        long start = System.nanoTime();

        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        sieveOfEratosthenes.sieve();

        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);

    }

    private void sieve()
    {

        BitVector vector = new BitVector(MAX);
        int[] seq = new int[]{2, 4, 2, 4, 6, 2, 6, 4,
                2, 4, 6, 6, 2, 6, 4, 2,
                6, 4, 6, 8, 4, 2, 4, 2,
                4, 8, 6, 4, 6, 2, 4, 6,
                2, 6, 6, 4, 2, 4, 6, 2,
                6, 4, 2, 4, 2, 10, 2, 10};
        int index = 0;
        for (int i = 11; i < Math.sqrt(MAX); i += seq[index++]) {
            if (!vector.isSet(i)) {
                int index2 = index;
                for (int j = i * i; j < MAX; j = j + seq[index2++] * i) {
                    vector.setBit(j);
                    if (index2 == 48) {
                        index2 = 0;
                    }
                }

            }
            if (index == 48) {
                index = 0;
            }

        }

        int count = 4;
        index = 0;
        for (int i = 11; i < MAX; i += seq[index++]) {
            if (!vector.isSet(i)) {
                count++;
            }
            if (index == 48) {
                index = 0;
            }
        }
        System.out.println(count);
    }

    private class BitVector
    {

        private int[] bitArray;

        public BitVector(long MAX)
        {
            bitArray = new int[(int) (MAX >> 6) + 1];
        }

        public void setBit(long i)
        {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            bitArray[index] = (bitArray[index]) | (1 << bit);
        }

        public boolean isSet(long i)
        {
            int index = (int) (i >> 6);
            int bit = (int) (i >> 1) & 31;
            return ((bitArray[index]) & (1 << bit)) != 0;
        }
    }


}
