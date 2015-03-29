package com.coderevisited.generics;

public class CovariantArrays {

    /**
     * This program throws runtime error. Because arrays are covariant,
     * assigning integer array to number array is successful at compile time
     * But, arrays enforce their element types at runtime. ArrayStoreException
     * is thrown while adding double to integer array
     */
    public static void main(String[] args) {

        Integer[] intArray = new Integer[5];
        Number[] objArray = intArray;
        objArray[0] = 1.0;

    }

}
