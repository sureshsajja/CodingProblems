package com.hackerrank.snapdeal;

import java.util.Scanner;

public class LIS
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int res;

        int _s_size = Integer.parseInt(in.nextLine());
        int[] _s = new int[_s_size];
        int _s_item;
        for (int _s_i = 0; _s_i < _s_size; _s_i++) {
            _s_item = Integer.parseInt(in.nextLine());
            _s[_s_i] = _s_item;
        }

        res = findLIS(_s);
        System.out.println(res);

    }

    static int findLIS(int[] s)
    {

        int[] temp = new int[s.length];
        int len;
        temp[0] = s[0];
        len = 1;
        for (int i = 1; i < s.length; i++) {
            if (s[i] < temp[0])
                temp[0] = s[i];
            else if (s[i] > temp[len - 1])
                temp[len++] = s[i];
            else {
                int index = search(temp, -1, len - 1, s[i]);
                temp[index] = s[i];
            }

        }
        return len;
    }

    private static int search(int A[], int low, int high, int key)
    {
        while (high - low > 1) {
            int mid = low + (high - low) / 2;
            if (A[mid] >= key) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return high;
    }


}
