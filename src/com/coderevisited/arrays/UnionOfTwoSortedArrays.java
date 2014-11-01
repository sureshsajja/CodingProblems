package com.coderevisited.arrays;

/**
 * For union of two arrays, follow the following merge procedure.
 * 1) Use two index variables i and j, initial values i = 0, j = 0
 * 2) If A[i] is smaller than B[j] then print A[i] and increment i.
 * 3) If A[i] is greater than B[j] then print B[j] and increment j.
 * 4) If both are same then print any of them and increment both i and j.
 * 5) Print remaining elements of the larger array.
 */
public class UnionOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        int[] A = new int[]{1, 3, 4, 5, 7};
        int[] B = new int[]{2, 3, 5, 6};
        findUnion(A, B);
    }

    private static void findUnion(int[] A, int[] B)
    {
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {

            if (A[i] < B[j]) {
                System.out.print(A[i] + " ");
                i++;
            } else if (A[i] > B[j]) {
                System.out.print(B[j] + " ");
                j++;
            } else {
                System.out.print(B[j] + " ");
                j++;
                i++;
            }

        }

        while (i < A.length) {
            System.out.print(A[i] + " ");
            i++;
        }

        while (j < B.length) {
            System.out.print(B[j] + " ");
            j++;
        }
    }
}
