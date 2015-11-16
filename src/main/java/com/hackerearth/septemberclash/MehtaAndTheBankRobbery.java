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

package com.hackerearth.septemberclash;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

//todo Not a correct solution
public class MehtaAndTheBankRobbery
{
    private static int[] primes = new int[]{2, 3, 5, 7, 11, 13, 17, 19, 23, 29};

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));


        class Item implements Comparable<Item>
        {
            private final long profit;
            private final int weight;
            private final int item;

            private Item(int item, long profit, int weight)
            {
                this.item = item;
                this.profit = profit;
                this.weight = weight;
            }

            public int getWeight()
            {
                return weight;
            }

            public long getProfit()
            {
                return profit;
            }


            public int compareTo(Item that)
            {
                if (this.profit < that.profit) {
                    return 1;
                } else if (this.profit > that.profit)
                    return -1;
                else {
                    if (this.weight < that.weight) {
                        return -1;
                    } else if (this.weight > that.weight) {
                        return 1;
                    } else {
                        if (this.item < that.item) {
                            return -1;
                        } else if (this.item > that.item) {
                            return 1;
                        } else
                            return 0;
                    }
                }
            }
        }

        int N = scanner.nextInt();
        int W = scanner.nextInt();

        Item[] array = new Item[N];


        for (int n = 0; n < N; n++) {
            array[n] = new Item(n, scanner.nextInt(), scanner.nextInt());
        }

        Arrays.sort(array);

        MehtaAndTheBankRobbery[][] K = new MehtaAndTheBankRobbery[N + 1][W + 1];

        for (int i = 0; i <= N; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = new MehtaAndTheBankRobbery(0L, 9);
                else if (array[i - 1].getWeight() <= w) {
                    MehtaAndTheBankRobbery p = K[i - 1][w - array[i - 1].getWeight()];
                    long a;
                    if (p.getIndex() >= 0) {
                        a = array[i - 1].getProfit() * primes[p.getIndex()] + p.getValue();
                    } else {
                        a = array[i - 1].getProfit() + p.getValue();
                    }
                    long b = K[i - 1][w].getValue();
                    if (a > b) {
                        K[i][w] = new MehtaAndTheBankRobbery(a, p.getIndex() - 1);
                    } else {
                        K[i][w] = K[i - 1][w];
                    }
                } else
                    K[i][w] = K[i - 1][w];
            }
        }

        pw.println(K[N][W].getValue());


        scanner.close();
        pw.close();
    }

    private final long value;
    private final int index;

    private MehtaAndTheBankRobbery(long value, int index)
    {
        this.value = value;
        this.index = index;
    }

    public long getValue()
    {
        return value;
    }

    public int getIndex()
    {
        return index;
    }
}
