package com.hackerearth.tatvik;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Stack;

//TODO Optimization needed
public class NiceArches
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int M = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < M; i++) {
            String a = scanner.next();
            boolean balanced = isBalanced(a, 'A', 'B');

            if (balanced) {
                result++;
            }
        }

        pw.println(result);

        scanner.close();
        pw.close();
    }

    private static boolean isBalanced(String s, char A, char B)
    {
        if ((s.length() & 1) != 0)
            return false;
        Stack<Character> stack = new Stack<Character>();
        boolean isA = false;
        boolean isB = false;
        for (char c : s.toCharArray()) {
            if (c == A) {
                if (isA) {
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != A)
                        return false;
                    else
                        isA = false;

                } else {
                    stack.push(c);
                    isA = true;
                }

            } else if (c == B) {
                if (isB) {
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != B)
                        return false;
                    else
                        isB = false;
                } else {
                    stack.push(c);
                    isB = true;
                }
            }
        }
        return stack.isEmpty();
    }
}
