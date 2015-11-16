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

package com.coderevisited.concurrency.visibility;

import java.util.concurrent.atomic.AtomicInteger;

public class NoVisibility
{
    private static AtomicInteger number = new AtomicInteger();
    private static boolean ready;

    public static void main(String[] args)
    {
        Thread a = new Thread(new Writer());
        a.start();
        Thread b = new Thread(new Reader());
        b.start();
    }

    private static class Reader
            implements Runnable
    {
        @Override
        public void run()
        {
            while (!ready) {
                Thread.yield();
            }
            for (int i = 0; i < 20; i++) {
                System.out.println("Read value as : " + number.get());
            }
        }
    }

    private static class Writer
            implements Runnable
    {
        @Override
        public void run()
        {
            System.out.println("Writing value as : " + number.getAndIncrement());
            ready = true;
            for (int i = 0; i < 20; i++) {
                System.out.println("Writing value as : " + number.getAndIncrement());
            }
        }
    }
}
