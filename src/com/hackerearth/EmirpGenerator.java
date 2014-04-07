package com.hackerearth;

import java.util.HashSet;
import java.util.Set;

public class EmirpGenerator {

    private static final int limit = 100000000;


    public static void main(String[] args) {

        EmirpGenerator generator = new EmirpGenerator();
        long start = System.nanoTime();
        generator.sieve();
        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);
    }

    private void sieve() {
        BitVector vector = new BitVector(limit);

        int[] seq = new int[]{4, 2};
        int upperX = (int) Math.sqrt(limit / 4) + 1;

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


        upperX = (int) Math.sqrt(limit / 3) + 1;

        for (int x = 1; x < upperX; x = x + 2) {
            int index = 0;
            int k1 = 3 * x * x;
            for (int y = 2; y < Math.sqrt(limit - k1); y += seq[++index & 1]) {
                int n = k1 + y * y;
                vector.toggle(n);
            }
        }

        upperX = (int) Math.sqrt(limit) + 1;

        for (int x = 1; x < upperX; x++) {
            int k1 = 3 * x * x;
            // if x is odd, values for y = 1, 5, 7 ...
            if ((x & 1) == 0) {
                int index = 1;
                for (int y = 1; y < x; y += seq[(++index & 1)]) {
                    int n = k1 - y * y;
                    if (n <= limit) vector.toggle(n);
                }
            } else {
                int index = 0;
                //if x is even, y values are 2, 4, 8, 10..
                for (int y = 2; y < x; y += seq[(++index & 1)]) {
                    int n = k1 - y * y;
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

        int count = 0;
        Set<Integer> emirps = new HashSet<Integer>(1000000);
        for (int i = 13; i < limit; i++) {
            if (vector.isSet(i)) {
                count++;
                //System.out.println(i);
                int reverse = reverse(i);
                if (reverse < limit && vector.isSet(reverse) && !emirps.contains(reverse)) {
                    emirps.add(i);
                    count++;
                }
            }
        }
        System.out.println(count);
//        for(int i : emirps){
//            System.out.println(i);
//        }
    }

    private int reverse(int number) {
        int reverseNumber = 0;
        while (number != 0) {
            int lastDigit = number % 10;
            number = number / 10;
            reverseNumber = reverseNumber * 10 + lastDigit;
        }
        return reverseNumber;
    }

    private class BitVector {

        private int[] bitArray;

        public BitVector(int MAX) {
            bitArray = new int[(MAX >> 5) + 1];
        }

        public boolean isSet(int i) {
            int index = (i >> 5);
            int bit = (i & 31);
            return ((bitArray[index]) & (1 << bit)) != 0;
        }

        public void toggle(int i) {
            int index = (i >> 5);
            int bit = (i & 31);
            bitArray[index] = (bitArray[index]) ^ (1 << bit);
        }

        public void unSet(int i) {
            int index = (i >> 5);
            int bit = (i & 31);
            bitArray[index] = (bitArray[index]) & ~(1 << bit);
        }
    }
}
