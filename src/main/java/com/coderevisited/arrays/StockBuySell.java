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

package com.coderevisited.arrays;

import java.util.LinkedList;
import java.util.List;

/**
 * Find possible pairs where we can buy at first index and sell at next index
 * 1. Start from index 0;
 * 2. Find index 'i' such that stock[i+1] > stock[i], set buy at i.
 * 3. Start from i+1, find index such that stock[i-1] > stock[i], set sell at i-1
 * 4. repeat until i = stock.length - 1;
 */
public class StockBuySell
{
    public static void main(String[] args)
    {
        int[] stock = new int[]{100, 180, 260, 310, 40, 535, 695, 50};
        List<Pair> result = findPossibleBuySell(stock);
        for (Pair p : result) {
            System.out.println(" Buy  at : " + p.buy + " Sell at : " + p.sell);
        }
    }

    private static List<Pair> findPossibleBuySell(int[] stock)
    {
        List<Pair> result = new LinkedList<>();
        int i = 0;

        while (i < stock.length - 1) {
            while (i < stock.length - 2 && stock[i + 1] <= stock[i])
                i++;

            Pair p = new Pair();
            p.buy = i++;

            while (i < stock.length - 1 && stock[i] >= stock[i - 1])
                i++;

            p.sell = i - 1;

            result.add(p);
        }

        return result;
    }

    private static class Pair
    {
        int buy;
        int sell;
    }
}
