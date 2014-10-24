package com.coderevisited.coding.arrays;

import java.util.LinkedList;
import java.util.List;

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

            p.sell = i-1;

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
