package com.coderevisited.autoboxing;


public class SumOfIntegers {

    private static int sumOfIntegerUptoN(int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        sumOfIntegerUptoN(1000000000);
        long end = System.currentTimeMillis();
        System.out.println((end - start));
    }

}
