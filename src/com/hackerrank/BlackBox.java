
package com.hackerrank;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


public class BlackBox
{

    private TreeSet<Integer> set;

    public BlackBox()
    {
        set = new TreeSet<Integer>(Collections.reverseOrder());

    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        BlackBox box = new BlackBox();
        for (int t = 0; t < T; t++) {
            int i = scanner.nextInt();
            if (i < 0) {
                box.remove(Math.abs(i));
            } else {
                box.add(i);
            }
            System.out.println(box.findMaxXOR());
        }

    }

    private static boolean ifNthBitSet(int A, int N)
    {
        return (A & (1 << N)) != 0;
    }

    public void add(Integer e)
    {
        set.add(e);
    }

    public void remove(Integer e)
    {
        set.remove(e);
    }

    public int findMaxXOR()
    {
        Integer[] array = new Integer[set.size()];
        array = set.toArray(array);
        int result = 0;
        if (array.length > 0) {
            int firstPos = Integer.numberOfLeadingZeros(array[0]);
            for (int i = 0; i < array.length; i++) {
                if (!ifNthBitSet(array[i], 31 - firstPos - i)) {
                    for (int k = i + 1; k < array.length; k++) {
                        if (ifNthBitSet(array[k], 31 - firstPos - i)) {
                            int temp = array[k];
                            array[k] = array[i];
                            array[i] = temp;
                            break;
                        }
                    }
                }
                int pow = (int) Math.pow(2, 31 - firstPos - i);
                for (int j = i + 1; j < array.length && array[j] >= pow; j++) {
                    array[j] = array[j] ^ array[i];
                }
            }
            for (Integer anArray : array) {
                int tempResult = result ^ anArray;
                result = result > tempResult ? result : tempResult;
            }
        }
        return result;
    }


}
