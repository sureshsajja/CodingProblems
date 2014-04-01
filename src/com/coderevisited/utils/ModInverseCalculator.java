package com.coderevisited.utils;

import java.math.BigInteger;
import java.util.Random;

public class ModInverseCalculator {

    public static void main(String[] args) {
        BigInteger largePrime = BigInteger.probablePrime(31, new Random());
        System.out.println("large prime generated " + largePrime.longValue());
        BigInteger inverse = BigInteger.valueOf(3L).modInverse(largePrime);
        System.out.println("multiplicative inverse of 3 modulo (prime number) = " + inverse);

        System.out.println("verification : (inverse*3) % (prime number) = " + (inverse.longValue() * 3L) % largePrime.longValue());


    }
}
