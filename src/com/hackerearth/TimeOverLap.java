package com.hackerearth;

import java.util.Scanner;

public class TimeOverLap
{

    private static int[] day = new int[24 * 60];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        boolean overlap = false;
        for (int t = 0; t < T; t++) {
            String[] startEnd = scanner.next().split("-");
            if (!overlap) {
                String[] startHHSS = startEnd[0].split(":");
                int HH = Integer.parseInt(startHHSS[0]);
                int MM = Integer.parseInt(startHHSS[1]);
                int startIndex = HH * 60 + MM;

                String[] endHhSs = startEnd[1].split(":");
                HH = Integer.parseInt(endHhSs[0]);
                MM = Integer.parseInt(endHhSs[1]);
                int endIndex = HH * 60 + MM;

                for (int i = startIndex; i < endIndex; i++) {
                    if (day[i] != 0) {
                        overlap = true;
                        break;
                    }
                    day[i] = 1;
                }
            }
        }
        if (overlap) {
            System.out.println("Will need a moderator!");
        } else {
            System.out.println("Who needs a moderator?");
        }
    }

}
