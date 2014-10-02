package com.coderevisited.coding;

public class ReplaceWithNextGreatest
{
    public static void main(String[] args)
    {
        int[] array = new int[]{16, 6, 9, 10, 11, 17, 4, 3, 9, 8, 5, 2, 14};
        replaceWithNextGreatest(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void replaceWithNextGreatest(int[] array)
    {
        int max = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            int current = array[i];
            array[i] = max;
            max = max > current ? max : current;
        }
    }
}
