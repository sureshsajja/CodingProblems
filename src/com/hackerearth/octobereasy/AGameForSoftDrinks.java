package com.hackerearth.octobereasy;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class AGameForSoftDrinks
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int Q = scanner.nextInt();
        for (int q = 0; q < Q; q++) {
            int N1 = scanner.nextInt();
            int N2 = scanner.nextInt();
            int N3 = scanner.nextInt();

            boolean found = false;
            while (true) {
                if (N1 > 0 && N1 % 2 == 1) {
                    N1--;
                    found = true;
                }
                if (N2 > 0 && N2 % 2 == 1) {
                    N2--;
                    found = true;
                }
                if (N3 > 0 && N3 % 2 == 1) {
                    N3--;
                    found = true;
                }
                if (found) {
                    found = false;
                } else {
                    pw.println("Aishwarya");
                    break;
                }


                if (N1 > 0 && N1 % 2 == 0) {
                    N1--;
                    found = true;
                }
                if (N2 > 0 && N2 % 2 == 0) {
                    N2--;
                    found = true;
                }
                if (N3 > 0 && N3 % 2 == 0) {
                    N3--;
                    found = true;
                }
                if (found) {
                    found = false;
                } else {
                    pw.println("Ashima");
                    break;
                }


            }

        }

        scanner.close();
        pw.close();
    }


}
