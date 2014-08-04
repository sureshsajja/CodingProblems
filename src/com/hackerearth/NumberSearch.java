package com.hackerearth;

import java.util.Scanner;

/**
 * Check if a number N is divisible by given number A or if N contains A in part
 * <p/>
 * Input: ====== 3 120 121 231
 * <p/>
 * Output: ====== The streak lives still in our heart! The streak is broken! The streak is broken!
 */
public class NumberSearch
{

    private static final int A = 21;

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int n = 0; n < T; n++) {
            if (search(n)) {
                System.out.println("The streak lives still in our heart!");
            } else {
                System.out.println("The streak is broken!");
            }
        }
    }

    private static boolean search(int n)
    {
        return n % A == 0 || String.valueOf(n).contains(String.valueOf(21));
    }
}
