package com.hackerearth;

import java.util.Scanner;

public class Comrades {

    private int[] array;
    private int rootindex;

    public Comrades(int N) {
        array = new int[N + 1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            Comrades comrades = new Comrades(N);
            for (int j = 1; j <= N; j++) {
                int k = scanner.nextInt();
                comrades.connect(j, k);
            }
            comrades.search();
        }
    }

    private void search() {
        int handshakes = 0;
        int fistBumps = 0;
        for (int i = 1; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int c1 = array[i];
                int c2 = array[j];

                if (c1 == c2) {
                    fistBumps++;
                    continue;
                }

                boolean found = false;

                while (c1 != 0) {
                    if (c1 == j) {
                        found = true;
                        handshakes++;
                        break;
                    }
                    c1 = array[c1];
                }

                while (!found && c2 != 0) {
                    if (i == c2) {
                        found = true;
                        handshakes++;
                        break;
                    }
                    c2 = array[c2];
                }

                if (!found)
                    fistBumps++;
            }
        }

        System.out.println(handshakes + " " + fistBumps);
    }

    private void connect(int j, int k) {
        array[j] = k;
        if (k == 0)
            rootindex = j;
    }
}
