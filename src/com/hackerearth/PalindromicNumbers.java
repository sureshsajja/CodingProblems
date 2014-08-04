package com.hackerearth;

import java.util.Scanner;

/**
 * Given A and B, count the numbers N such that A ≤ N ≤ B and N is a palindrome.
 */
public class PalindromicNumbers
{

    private static int[] palindrome = new int[100001];

    public static void main(String[] args)
    {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {

            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int count = 0;
            for (int j = A; j <= B; j++) {
                if (isPalindrome(j)) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isPalindrome(int j)
    {

        int reverseNumber = 0;
        int origNumber = j;

        if (palindrome[j] == 0) {

            while (j != 0) {
                int lastDigit = j % 10;
                j = j / 10;
                reverseNumber = reverseNumber * 10 + lastDigit;
            }

            if (reverseNumber == origNumber) {
                palindrome[reverseNumber] = 1;
                palindrome[origNumber] = 1;
            } else {
                palindrome[origNumber] = -1;
            }
        }

        return palindrome[origNumber] == 1;


    }
}
