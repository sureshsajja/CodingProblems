package com.coderevisited.autoboxing;


public class UnIntentionalObjectCreation {

    private static Integer sumOfIntegerUptoN(Integer N) {
        Integer sum = 0;
        for (Integer i = 0; i < N; i++) {
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
