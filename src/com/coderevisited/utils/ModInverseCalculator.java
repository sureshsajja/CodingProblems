package com.coderevisited.utils;

import java.math.BigInteger;
import java.util.Random;

public class ModInverseCalculator {

    private BigInteger largePrime;

    public ModInverseCalculator(long largePrime) {
        this.largePrime = BigInteger.valueOf(largePrime);
    }

    public static void main(String[] args) {

        BigInteger largePrime = BigInteger.probablePrime(61, new Random());
        ModInverseCalculator calc = new ModInverseCalculator(largePrime.longValue());
        long inverse = calc.modInverse(3L);

        System.out.println("large prime generated " + largePrime.longValue());
        System.out.println("multiplicative inverse of 3 modulo (prime number) = " + inverse);
        System.out.println("verification : (inverse*3) % (prime number) = " + (inverse * 3L) % largePrime.longValue());
    }


    public long modInverse(long value) {
        BigInteger inverse = BigInteger.valueOf(value).modInverse(largePrime);
        return inverse.longValue();

    }
}
