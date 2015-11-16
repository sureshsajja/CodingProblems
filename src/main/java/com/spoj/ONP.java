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

package com.spoj;


import java.io.*;
import java.util.*;

/**
 * http://www.spoj.com/problems/ONP/
 */
public class ONP {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static Map<Character, Integer> operatorsMap = new HashMap<>();

    static {
        operatorsMap.put('+', 0);
        operatorsMap.put('-', 1);
        operatorsMap.put('*', 2);
        operatorsMap.put('/', 3);
        operatorsMap.put('^', 4);
    }

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(
                    reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        tokenizer = new StringTokenizer("");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = nextInt();
        for (int t = 0; t < T; t++) {
            String expression = next();
            String result = convert(expression.toCharArray());
            pw.println(result);
        }


        reader.close();
        pw.close();

    }

    private static String convert(char[] chars) {

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (char c : chars) {
            if (isOperand(c)) {
                queue.add(c);
            }
            if (isOperator(c)) {
                while (!stack.isEmpty()) {
                    Character peek = stack.peek();
                    if (comparePrecedence(peek, c)) {
                        queue.add(stack.pop());
                    } else
                        break;
                }
                stack.push(c);
            } else if (isLeftParentheses(c)) {
                stack.push(c);
            } else if (isRightParentheses(c)) {
                boolean isLeftFound = false;
                while (!stack.isEmpty()) {
                    Character top = stack.pop();
                    if (!isLeftParentheses(top)) {
                        queue.add(top);
                    } else {
                        isLeftFound = true;
                        break;
                    }
                }
                if (!isLeftFound)
                    throw new RuntimeException("Parentheses are not balanced");
            }
        }

        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (isLeftParentheses(top) || isRightParentheses(top)) {
                throw new RuntimeException("Parentheses are not balanced");
            }
            queue.add(top);
        }

        Iterator<Character> itr = queue.iterator();

        StringBuilder sb = new StringBuilder();
        while (itr.hasNext()) {
            sb.append(itr.next());
        }

        return sb.toString();

    }

    private static boolean isRightParentheses(char token) {
        return token == ')';
    }

    private static boolean isLeftParentheses(char token) {
        return token == '(';
    }

    private static boolean comparePrecedence(char peek, char token) {
        return isOperator(peek) && operatorsMap.get(peek) > operatorsMap.get(token);
    }

    private static boolean isOperand(char c) {
        return c >= 'a' && c <= 'z';
    }

    private static boolean isOperator(char c) {
        return operatorsMap.containsKey(c);
    }

}
