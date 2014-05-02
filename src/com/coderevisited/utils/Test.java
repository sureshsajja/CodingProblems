package com.coderevisited.utils;

public class Test {

    public static void main(String[] args) {

        int[] array = new int[]{100151, 100129, 100109, 100103, 100069, 11, 7, 5, 3};

        long sum = 0;
        for (int j = 0; j < array.length - 1; j++) {
            sum = (sum + (100000 - 1 - j) * array[j]);
            sum = (sum - (100000 - 1 - j) * array[array.length - 1 - j]);
            System.out.println("sum : " + sum);
        }

        System.out.println((sum * 100151) % 1000000007L);

        sum = 0;
        for (int j = 0; j < array.length - 1; j++) {
            sum = (sum + (100000 - 1 - j) * array[j] - (100000 - 1 - j) * array[array.length - 1 - j]) % 1000000007L;
            System.out.println("sum : " + sum);

        }


        System.out.println((sum * 100151) % 1000000007L);
    }
}
