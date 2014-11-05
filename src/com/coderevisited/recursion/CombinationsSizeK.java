package com.coderevisited.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CombinationsSizeK
{
    public static void main(String[] args)
    {
        String s = "abcde";
        printCombinations(s, "", 3);

        int[] array = new int[]{3, 4, 5, 6, 7};
        printNumbers(0, array, 0, new int[3]);
        Map<Integer, List<Integer[]>> map = new HashMap<>();
        findAllCombinations(0, array, 0, new int[array.length], map);
        for (int key : map.keySet()) {
            System.out.println("Printing combinations of size : " + key);
            List<Integer[]> list = map.get(key);
            for (Integer[] combArray : list) {
                for (int i : combArray) {
                    System.out.print(i + " ");
                }
                System.out.println();
            }
        }
    }

    private static void printNumbers(int start, int[] array, int K, int[] result)
    {
        if (K == 2) {
            for (int i = 0; i < K; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = start; i < array.length; i++) {
            result[K] = array[i];
            printNumbers(i + 1, array, K + 1, result);
        }
    }


    private static void findAllCombinations(int start, int[] array, int K, int[] result, Map<Integer, List<Integer[]>> map)
    {
        if (K > 1) {
            if (!map.containsKey(K)) {
                map.put(K, new ArrayList<Integer[]>());
            }
            List<Integer[]> list = map.get(K);
            Integer[] temp = new Integer[K];

            list.add(temp);
            for (int i = 0; i < K; i++) {
                //System.out.print(result[i] + " ");
                temp[i] = result[i];
            }
        }
        for (int i = start; i < array.length; i++) {
            result[K] = array[i];
            findAllCombinations(i + 1, array, K + 1, result, map);
        }
    }


    private static void printCombinations(String s, String prefix, int K)
    {
        if (prefix.length() == K) {
            System.out.println(prefix);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            printCombinations(s.substring(i + 1, s.length()), prefix + s.charAt(i), K);
        }
    }
}
