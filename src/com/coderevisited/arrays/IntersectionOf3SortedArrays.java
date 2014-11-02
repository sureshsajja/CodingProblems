package com.coderevisited.arrays;

/**
 * 1. Use three index variables i,j and k, initial values i = 0, j = 0, k = 0
 * 2. if A[i]==B[j]==C[k], print A[i] as one common integer
 * 3. if A[i] < B[j] increment i.
 * 4. if B[j] < C[k] increment j.
 * 5. else increment k.
 */
public class IntersectionOf3SortedArrays
{
    public static void main(String[] args)
    {
        int[] A = new int[]{1, 5, 10, 20, 40, 80};
        int[] B = new int[]{6, 7, 20, 80, 100};
        int[] C = new int[]{3, 4, 15, 20, 30, 70, 80, 120};
        findIntersection(A, B, C);
    }

    private static void findIntersection(int[] A, int[] B, int[] C)
    {
        int i = 0, j = 0, k = 0;
        while (i < A.length && j < B.length && k < C.length) {
            if ((A[i] == B[j]) && (B[j] == C[k])) {
                System.out.print(A[i] + " ");
                i++;
                j++;
                k++;
            } else if (A[i] < B[j]) {
                i++;
            } else if (B[j] < C[k]) {
                j++;
            } else {
                k++;
            }
        }

    }
}
