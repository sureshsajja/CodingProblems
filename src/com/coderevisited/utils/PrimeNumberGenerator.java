package com.coderevisited.utils;

/**
 * Implementation of Sieve of Atkin.. Generating prime numbers up to 1 billion
 */
public class PrimeNumberGenerator {

    private static final long limit = 1000000000L;


    public static void main(String[] args) {

        PrimeNumberGenerator generator = new PrimeNumberGenerator();
        long start = System.nanoTime();
        generator.sieve();
        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);
    }

    private void sieve() {
        BitVector vector = new BitVector(limit);

        int[] seq = new int[]{4, 2};
        long upperX = (long) Math.sqrt(limit / 4) + 1;

        for (int x = 1; x < upperX; x++) {
            int k1 = 4 * x * x;
            if (x % 3 == 0) {
                int index = 0;
                for (int y = 1; y < Math.sqrt(limit - k1); y += seq[index++ & 1]) {
                    int n = k1 + y * y;
                    vector.toggle(n);
                }
            } else {
                for (int y = 1; y < Math.sqrt(limit - k1); y = y + 2) {
                    int n = k1 + y * y;
                    vector.toggle(n);
                }
            }
        }


        upperX = (long) Math.sqrt(limit / 3) + 1;

        for (int x = 1; x < upperX; x = x + 2) {
            int index = 0;
            int k1 = 3 * x * x;
            for (int y = 2; y < Math.sqrt(limit - k1); y += seq[++index & 1]) {
                int n = k1 + y * y;
                vector.toggle(n);
            }
        }

        upperX = (long) Math.sqrt(limit) + 1;

        for (long x = 1; x < upperX; x++) {
            long k1 = 3 * x * x;
            // if x is odd, values for y = 1, 5, 7 ...
            if ((x & 1) == 0) {
                int index = 1;
                for (long y = 1; y < x; y += seq[(++index & 1)]) {
                    long n = k1 - y * y;
                    if (n <= limit) vector.toggle(n);
                }
            } else {
                int index = 0;
                //if x is even, y values are 2, 4, 8, 10..
                for (long y = 2; y < x; y += seq[(++index & 1)]) {
                    long n = k1 - y * y;
                    if (n <= limit) vector.toggle(n);
                }
            }
        }

        for (int i = 5; i < Math.sqrt(limit); i++) {
            if (vector.isSet(i)) {
                for (int k = i * i; k < limit; k += i * i) {
                    vector.unSet(k);
                }
            }
        }

        int count = 2;
        for (int i = 5; i < limit; i++) {
            if (vector.isSet(i)) {
                count++;
                //System.out.println(i);
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

        public void toggle(long i) {
            int index = (int) (i >> 5);
            int bit = (int) (i & 31);
            bitArray[index] = (bitArray[index]) ^ (1 << bit);
        }

        public void unSet(long i) {
            int index = (int) (i >> 5);
            int bit = (int) (i & 31);
            bitArray[index] = (bitArray[index]) & ~(1 << bit);
        }
    }
}
