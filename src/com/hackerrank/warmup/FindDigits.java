package com.hackerrank.warmup;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindDigits
{

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long n = scanner.nextLong();
            long number = n;
            List<Long> digits = new ArrayList<Long>();
            while (n != 0) {
                long lastDigit = n % 10;
                n = n / 10;
                digits.add(lastDigit);
            }

            int result = 0;
            for (Long l : digits) {
                if (l != 0) {
                    if (number % l == 0)
                        result++;
                }
            }

            pw.println(result);
        }
        pw.close();
        scanner.close();
    }

}
