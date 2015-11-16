/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
