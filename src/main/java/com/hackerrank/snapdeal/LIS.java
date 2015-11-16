/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
