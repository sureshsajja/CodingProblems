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

import java.util.StringTokenizer;

/**
 * Fully parenthesized arithmetic expression evaluation using dijkstra's 2 stack
 * algorithm
 * 
 * For evaluation and easy parsing, assuming a space between each operand and
 * operator.
 * 
 * @author sureshsajja
 * 
 */
public class InFixEvaluation {

	private static final String[] operators = new String[] { "+", "-", "/",
			"*", "%" };
	private static final String[] ingoreStrings = new String[] { " ", "(" };

	public static void main(String[] args) {
		String expression = "( 2 + ( 3 * ( 7 - 5 ) ) )";
		Stack<Integer> valStack = new ResizableArrayStack<>(2);
		Stack<String> opsStack = new ResizableArrayStack<>(2);

		StringTokenizer st = new StringTokenizer(expression, " ");

		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (isOperator(s)) {
				opsStack.push(s);
			} else if (isIgnoreString(s)) {
				// do nothing
			} else if (isNumber(s)) {
				valStack.push(Integer.valueOf(s));
			} else if (s.equalsIgnoreCase(")")) {
				Integer operand2 = valStack.pop();
				Integer operand1 = valStack.pop();
				String operator = opsStack.pop();
				Integer result = evaluate(operand1, operand2, operator);
				valStack.push(result);
			} else
				System.out.println("Invalid expression "+s);
		}

		

		System.out.println("Value of expression " + expression + " is "
				+ valStack.pop());
	}

	private static Integer evaluate(Integer operand1, Integer operand2,
			String operator) {
		if (operator.equalsIgnoreCase("-")) {
			return operand1 - operand2;
		} else if (operator.equalsIgnoreCase("+")) {
			return operand1 + operand2;
		} else if (operator.equalsIgnoreCase("*")) {
			return operand1 * operand2;
		} else if (operator.equalsIgnoreCase("/")) {
			return operand1 / operand2;
		} else {
			System.out.println("Invalid operator "+operator);
			return 0;
		}
	}

	private static boolean isNumber(String s) {
		return s.matches("\\d+");
	}

	private static boolean isIgnoreString(String ignoreString) {
		for (String s : ingoreStrings) {
			if (s.equalsIgnoreCase(ignoreString))
				return true;
		}
		return false;
	}

	private static boolean isOperator(String operator) {
		for (String s : operators) {
			if (s.equalsIgnoreCase(operator))
				return true;
		}
		return false;
	}

}
