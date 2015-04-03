package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

/**
 * Nikki's latest work is writing an story of letters. However, she finds writing story so boring that, after working for three hours, she realized that all she has written are M long words consisting entirely of letters A and B. Having accepted that she will never finish the story in time, poor Nikki has decided to at least have some fun with it by counting bubbly words.
 * <p/>
 * Now Nikki is connecting pairs of identical letters (A with A, B with B) by drawing arches above the word. A given word is bubbly if each letter can be connected to exactly one other letter in such a way that no two arches intersect. So here is your task. Help Nikki count how many words are bubbly.
 * <p/>
 * Input :
 * <p/>
 * The first line of input contains the positive integer M , the number of words written down by Nikki. Each of the following M lines contains a single word consisting of letters A and B, with length between 2 and 10^5, inclusive. The sum of lengths of all words doesn't exceed 10^6.
 * <p/>
 * Output :
 * <p/>
 * The first and only line of output must contain the number of bubbly words.
 * <p/>
 * Constraints:
 * <p/>
 * 1 <= M <= 100
 * <p/>
 * <p/>
 * Input
 * =====
 * 3
 * ABAB
 * AABB
 * ABBA
 * <p/>
 * Output
 * ======
 * 2
 * <p/>
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
