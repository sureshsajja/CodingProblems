package com.coderevisited.math.prime;

import java.util.BitSet;

public class SieveOfEratosthenes
{
    private static int MAX = 1000000000;
    private static BitSet bitSet = new BitSet(MAX);

    public static void main(String[] args)
    {

        long start = System.nanoTime();

        sieve();

        System.out.println((double) (System.nanoTime() - start) / 1000000000.0);

    }

    private static void sieve()
    {
        for (int i = 3; i < Math.sqrt(MAX); i += 2) {
            if (!bitSet.get(i)) {
                for (int j = i * i; j < MAX; j += i) {
                    bitSet.set(j);
                }
            }
        }

        int count = 1;
        for (int i = 3; i < MAX; i += 2) {
            if (!bitSet.get(i)) {
                count++;
            }
        }
        System.out.println(count);
    }
}
