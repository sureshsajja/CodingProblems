package com.hackerearth.aprileasy14;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * User : Suresh
 * Date : 29/03/15
 */

/**
 * Little Deepu since his breakup has been obsessed with XOR, so now he passes his time by calculating XOR of various numbers.
 * To help Little Deepu pass his time, his friend Rahul gives him an array of N numbers and asks him to calculate XOR of a range of numbers, from ath numbert to bth number (both a and b inclusive and are 0-based).
 * <p/>
 * Input
 * The first line contains T, the number of test cases.
 * First line of each test case contains N, the number of elements in the array
 * Next line contains N integers, where ith integer is the ith element of the array
 * The line after that contains Q, the number of XOR queries to be performed on the array
 * Next Q lines each contain a and b, the range of indices for which XOR is to be calculated.
 * <p/>
 * Output
 * For each query a, b you need to print
 * array[a] XOR array[a+1] XOR ... XOR array[b]
 * <p/>
 * Constraints:
 * 1 ≤ T ≤ 5
 * 1 ≤ N ≤ 100000
 * 1 ≤ array[i] ≤ 1000000
 * 1 ≤ Q ≤ 50000
 * <p/>
 * Sample Input
 * 1
 * 3
 * 2 3 2
 * 2
 * 0 2
 * 1 2
 * <p/>
 * Sample Output
 * 3
 * 1
 */
public class SubarrayXOR {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] XOR = new int[N];
            int prev = 0;
            for (int n = 0; n < N; n++) {
                int i = scanner.nextInt();
                XOR[n] = prev ^ i;
                prev = XOR[n];
            }
            int Q = scanner.nextInt();
            for (int q = 0; q < Q; q++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if (a > 0)
                    pw.println(XOR[a - 1] ^ XOR[b]);
                else
                    pw.println(XOR[b]);
            }
        }

        scanner.close();
        pw.close();
    }
}
