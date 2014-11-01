package com.coderevisited.arrays;

/**
 * For Intersection of two arrays, print the element only if the element is present in both arrays.
 * 1. Use two index variables i and j, initial values i = 0, j = 0
 * 2. If A[i] is smaller than B[j] then increment i.
 * 3.  If A[i] is greater than B[j] then increment j.
 * 4. If both are same then print any of them and increment both i and j.
 */
public class IntersectionOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] A = new int[]{1, 3, 4, 5, 7};
        int[] B = new int[]{2, 3, 5, 6};
        findIntersection(A, B);
    }

    private static void findIntersection(int[] A, int[] B)
    {

        int i = 0;
        int j = 0;
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                i++;
            } else if (A[i] > B[j]) {
                j++;
            } else {
                System.out.print(B[j] + " ");
                j++;
                i++;
            }

        }

    }

}
