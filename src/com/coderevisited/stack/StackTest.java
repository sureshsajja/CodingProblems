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

package com.coderevisited.stack;

/**
 * Sample test client
 *
 * @author sureshsajja
 */
public class StackTest {


    public static void main(String[] args) {
        AdvancedStack<Integer> stack = new LinkedListAdvancedStack<>();
        stack.push(3);
        stack.push(6);
        stack.push(4);
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.push(0);

        System.out.println("Size of the Stack " + stack.size());

        for (int i : stack) {
            System.out.println(i);
        }

        System.out.println("Elem from Stack " + stack.pop());
        System.out.println("Elem from Stack " + stack.pop());
        System.out.println("Elem from Stack " + stack.pop());

        System.out.println("Size of the Stack " + stack.size());

        for (int i : stack) {
            System.out.println(i);
        }

        System.out.println("Max of the Stack " + stack.getMax());
        stack.push(8);

        for (int i : stack) {
            System.out.println(i);
        }
        System.out.println("Max of the Stack " + stack.getMax());
        stack.pop();
        for (int i : stack) {
            System.out.println(i);
        }
        System.out.println("Max of the Stack " + stack.getMax());

        Integer[] items = new Integer[8];
        items = stack.multiPop(8, items);
        for (Integer i : items) {
            System.out.println(i);
        }

    }
}
