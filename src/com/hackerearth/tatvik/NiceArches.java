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

package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerearth.com/problem/algorithm/nice-arches-1/
 * Solution
 * =======
 * The problem is just one variation of classic problem check if given parentheses are balanced.
 * http://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
 */
public class NiceArches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int M = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < M; i++) {
            String a = scanner.next();
            boolean balanced = isBalanced(a);

            if (balanced) {
                result++;
            }
        }

        pw.println(result);

        scanner.close();
        pw.close();
    }

    private static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == 'A') {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    Character peek = stack.peek();
                    if (peek != 'A')
                        stack.push(c);
                    else {
                        stack.pop();
                    }
                }
            } else if (c == 'B') {
                if (stack.isEmpty())
                    stack.push(c);
                else {
                    Character peek = stack.peek();
                    if (peek != 'B')
                        stack.push(c);
                    else {
                        stack.pop();
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
