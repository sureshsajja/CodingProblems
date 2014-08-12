package com.hackerearth;

import java.util.Scanner;

/**
 * Write a program to find the mode of a given list of integers. Mode of a number is defined as the number which is most
 * frequently occurred. For example: L = {1,2,2,3} // Here mode is 2(most frequently occurred) It is possible that
 * multiple answers are possible for a list. In that case print all possible answers in non decreasing order.
 * Input:
 * First Line of input contains an integer t representing the number of test cases, Where first line of each test case
 * has an integers N - number of integers in list, Next line contains N integers.
 * Output:
 * print all the possible modes in non-increasing order.
 * Constraints:
 * 1<=t<=100 1<=N<100000 1<=a[i]<=1000000
 */
public class FindMode
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] array = new int[1000001];
            int max = 0;
            for (int n = 0; n < N; n++) {
                int i = scanner.nextInt();
                array[i]++;
                max = Math.max(array[i], max);
            }

            for (int n = 1000000; n >= 0; n--) {
                if (array[n] == max) {
                    System.out.print(n + " ");
                }
            }
            System.out.println();
        }
    }
}
