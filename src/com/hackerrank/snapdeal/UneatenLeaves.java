package com.hackerrank.snapdeal;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 1. Include the cardinalities of the sets.
 * 2. Exclude the cardinalities of the pairwise intersections.
 * 3. Include the cardinalities of the triple-wise intersections.
 * 4. Exclude the cardinalities of the quadruple-wise intersections.
 * 5. Include the cardinalities of the quintuple-wise intersections.
 * 6. Continue, until the cardinality of the n-tuple-wise intersection is included (if n is odd) or excluded (n even).
 * <p/>
 * http://en.wikipedia.org/wiki/Inclusion%E2%80%93exclusion_principle
 */
public class UneatenLeaves
{

    public static void main(String[] args) throws IOException
    {
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int res;
        int _N;
        _N = 100;
        int[] _A = new int[]{2, 4, 5};
        res = countUneatenLeavesBruteForce(_N, _A);
        pw.println(res);
        res = countUneatenLeaves(_N, _A);
        pw.println(res);
        pw.close();
    }

    private static int countUneatenLeaves(int n, int[] a)
    {
        return 0;
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

    private static int countUneatenLeavesBruteForce(int N, int[] A)
    {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            boolean found = false;
            for (int j : A) {
                if (i >= j && i % j == 0) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                count++;
            }
        }
        return count;
    }

    private static int lcm(int a, int b)
    {
        return a * (b / gcd(a, b));
    }

    private static int gcd(int a, int b)
    {
        while (b > 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}

