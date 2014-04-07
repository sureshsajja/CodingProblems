package com.hackerearth;

import java.util.HashSet;
import java.util.Set;

/**
 * Generate as many distinct primes P such that reverse (P) is also prime and is not equal to P.
 */
public class EmirpGenerator {

    private static final int limit = 400000000;
    private static int[] reverse = new int[400000000];
    private static boolean[] primes = new boolean[400000000];


    public static void main(String[] args) {

        EmirpGenerator generator = new EmirpGenerator();
        long start = System.nanoTime();
        generator.sieve();
        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);
    }

    private void sieve() {

        int[] seq = new int[]{4, 2};
        int upperX = (int) Math.sqrt(limit / 4) + 1;

        for (int x = 1; x < upperX; x++) {
            int k1 = 4 * x * x;
            if (x % 3 == 0) {
                int index = 0;
                for (int y = 1; y < Math.sqrt(limit - k1); y += seq[index++ & 1]) {
                    int n = k1 + y * y;
                    primes[n] = !primes[n];
                }
            } else {
                for (int y = 1; y < Math.sqrt(limit - k1); y = y + 2) {
                    int n = k1 + y * y;
                    primes[n] = !primes[n];
                }
            }
        }

        upperX = (int) Math.sqrt(limit / 3) + 1;

        for (int x = 1; x < upperX; x = x + 2) {
            int index = 0;
            int k1 = 3 * x * x;
            for (int y = 2; y < Math.sqrt(limit - k1); y += seq[++index & 1]) {
                int n = k1 + y * y;
                primes[n] = !primes[n];
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
                    if (n <= limit) primes[n] = !primes[n];
                }
            } else {
                int index = 0;
                //if x is even, y values are 2, 4, 8, 10..
                for (int y = 2; y < x; y += seq[(++index & 1)]) {
                    int n = k1 - y * y;
                    if (n <= limit) primes[n] = !primes[n];
                }
            }
        }

        for (int i = 5; i < Math.sqrt(limit); i++) {
            if (primes[i]) {
                for (int k = i * i; k < limit; k += i * i) {
                    primes[k] = false;
                }
            }
        }


        Set<Integer> emirps = new HashSet<Integer>(1000000);
        for (int i = 13; i < limit; i++) {
            if (primes[i]) {
                int reverse = reverse(i);
                if (reverse < limit && primes[reverse] && !emirps.contains(reverse)) {
                    emirps.add(i);
                }
            }
        }
        System.out.println(emirps.size());
        for (int i : emirps) {
            System.out.println(i);
        }
    }

    private int reverse(int number) {

        int orignum = number;

        if (reverse[number] == 0) {
            int reverseNumber = 0;
            while (number != 0) {
                int lastDigit = number % 10;
                number = number / 10;
                reverseNumber = reverseNumber * 10 + lastDigit;
            }
            reverse[orignum] = reverseNumber;
            if (reverseNumber < limit)
                reverse[reverseNumber] = orignum;
        }
        return reverse[orignum];
    }
}
