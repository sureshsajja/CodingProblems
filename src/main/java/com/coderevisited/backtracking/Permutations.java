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

package com.coderevisited.backtracking;

/**
 * 1. recursively print permutations by swapping elements
 * 2. after each step back track to previous step
 */
public class Permutations
{
    public static void main(String[] args)
    {
        String str = "ABC";
        printPermutations(str.toCharArray(), 0, str.length() - 1);
    }

    private static void printPermutations(char[] chars, int index, int length)
    {

        if (length == index) {
            System.out.println(chars);
        }

        for (int i = index; i <= length; i++) {
            //swap elements
            swap(chars, i, index);
            printPermutations(chars, index + 1, length);
            //backtrack
            swap(chars, i, index);
        }

    }

    private static void swap(char[] chars, int i, int j)
    {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }
}
