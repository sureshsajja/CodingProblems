package com.coderevisited.utils;

/**
 * Implementation of Sieve Of Eratosthenes.. Generating prime numbers up to 1 billion
 */
public class SieveOfEratosthenes {

    private static final int MAX = 1000000000;
    private static final int MEMORY_SIZE = MAX >> 1;


    public static void main(String[] args) {

        long start = System.nanoTime();

        SieveOfEratosthenes sieveOfEratosthenes = new SieveOfEratosthenes();
        sieveOfEratosthenes.sieve();

        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);

    }

    private void sieve() {

        BitVector vector = new BitVector(MEMORY_SIZE);
        for (int i = 3; i < Math.sqrt(MAX); i = i + 2) {
            if (!vector.isSet(i >> 1)) {
                for (int j = (i * i) >> 1; j < MEMORY_SIZE; j = j + i) {
                    vector.setBit(j);
                }

            }
        }

        int count = 1;
        for (int i = 3; i < MAX; i = i + 2) {
            if (!vector.isSet(i >> 1)) {
                count++;
            }
        }
        System.out.println(count);
    }

    private class BitVector {

        private int[] bitArray;

        public BitVector(long MAX) {
            bitArray = new int[(int) (MAX >> 5) + 1];
        }

        public void setBit(long i) {
            int index = (int) (i >> 5);
            int bit = (int) (i & 31);
            bitArray[index] = (bitArray[index]) | (1 << bit);
        }

        public boolean isSet(long i) {
            int index = (int) (i >> 5);
            int bit = (int) (i & 31);
            return ((bitArray[index]) & (1 << bit)) != 0;
        }
    }


}
