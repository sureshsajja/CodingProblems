package com.hackerrank.mobileiron;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 22-08-2016
 */
public class Balanced {

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {


        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {
        int N = nextInt();
        String[] array = new String[N];
        for (int n = 0; n < N; n++) {
            array[n] = next();
        }

        String[] result = checkforBalance(array);
        for (String s : result) {
            pw.println(s);
        }
    }

    private static String[] checkforBalance(String[] array) {
        String[] result = new String[array.length];
        int i = 0;
        for (String parantheses : array) {
            if (checkforBalance(parantheses))
                result[i++] = "Yes";
            else
                result[i++] = "No";
        }
        return result;
    }

    private static boolean checkforBalance(String parentheses) {
        Stack<Character> stack = new Stack<>();
        char[] array = parentheses.toCharArray();
        for (char c : array) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if (pop != '(')
                    return false;
            } else if (c == '}') {
                if (stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if (pop != '{')
                    return false;
            } else if (c == ']') {
                if (stack.isEmpty())
                    return false;
                char pop = stack.pop();
                if (pop != '[')
                    return false;
            }

        }
        return stack.isEmpty();
    }

}
