package com.hackerrank;

import java.io.*;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class BlackBox
{
    private static int[] mathPow = new int[]{1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824};
    private Set<Integer> list;

    private static PrintWriter pw;

    static {
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public BlackBox()
    {
        list = new TreeSet<Integer>();

    }

    public static void main(String[] args)
    {
        long startMs = System.currentTimeMillis();
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        BlackBox box = new BlackBox();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            if (i < 0) {
                box.remove(-1 * i);
            } else {
                box.add(i);
            }
            pw.println(box.findMaxXOR());
            // box.findMaxXOR();
        }

        long time = (System.currentTimeMillis() - startMs) / 1000;
        pw.println(time);
        pw.close();

    }

    public void add(Integer e)
    {
        list.add(e);
    }

    public void remove(Integer e)
    {
        list.remove(e);
    }

    private int findMaxXOR()
    {

        int[] array = new int[list.size()];
        Iterator<Integer> itr = list.iterator();
        for (int i = 0; i < array.length; i++) {
            array[array.length - 1 - i] = itr.next();
        }

        if (array.length == 0)
            return 0;

        int bitPos = 0;

        while (mathPow[bitPos] <= array[0])
            bitPos++;

        bitPos--;

        for (int p = bitPos, index = 0; p >= 0; p--) {

            int pow = mathPow[p];
            int k = index;
            while (k < array.length && (array[k] & pow) == 0) k++;
            if (k >= array.length)
                continue;

            int temp = array[k];
            array[k] = array[index];
            array[index] = temp;

            for (int j = 0; j < array.length; j++) {
                if (j != index && (array[j] & pow) != 0)
                    array[j] = array[j] ^ array[index];
            }
            index++;
        }

        int result = 0;
        for (Integer anArray : array) {
            result = result ^ anArray;
        }

        return result;

    }
}
