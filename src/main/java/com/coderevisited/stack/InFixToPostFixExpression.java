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

import com.coderevisited.queue.LinkedListQueue;
import com.coderevisited.queue.Queue;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;


/**
 * This program implements Dijkstra's shunting-yard algorithm to convert an
 * infix expression into a postfix expression. This program supports operator
 * precedence, including both left and right associative operators.
 * 
 * http://en.wikipedia.org/wiki/Shunting-yard_algorithm
 * 
 * @author sureshsajja
 * 
 */
public class InFixToPostFixExpression {

	private static Map<String, Operators> operatorsMap = new HashMap<>();
	private static final int LEFT_ASSOCIATIVITY = 0;

	static {
		operatorsMap.put("+", Operators.ADD);
		operatorsMap.put("-", Operators.SUBTRACT);
		operatorsMap.put("*", Operators.MULTIPLY);
		operatorsMap.put("/", Operators.DIVIDE);
	}

	private enum Operators {
		ADD {
			@Override
			public int getAssociativity() {
				return LEFT_ASSOCIATIVITY;
			}

			@Override
			public int getPrecedence() {
				return 2;
			}

			@Override
			public int evaluate(int d1, int d2) {
				return d1 + d2;
			}
		},
		SUBTRACT {
			@Override
			public int getAssociativity() {
				return LEFT_ASSOCIATIVITY;
			}

			@Override
			public int getPrecedence() {
				return 2;
			}

			@Override
			public int evaluate(int d1, int d2) {
				return d1 - d2;
			}
		},
		MULTIPLY {
			@Override
			public int getAssociativity() {
				return LEFT_ASSOCIATIVITY;
			}

			@Override
			public int getPrecedence() {
				return 3;
			}

			@Override
			public int evaluate(int d1, int d2) {
				return d1 * d2;
			}
		},
		DIVIDE

		{
			@Override
			public int getAssociativity() {
				return LEFT_ASSOCIATIVITY;
			}

			@Override
			public int getPrecedence() {
				return 3;
			}

			@Override
			public int evaluate(int d1, int d2) {
				return d1 / d2;
			}
		};
		public abstract int getAssociativity();

		public abstract int getPrecedence();

		public abstract int evaluate(int d1, int d2);
	}

	public static String inFixToPostFix(String s) {

		Queue<String> output = new LinkedListQueue<>();
		Stack<String> stack = new LinkedListStack<>();

		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (isNumber(token)) {
				output.enqueue(token);
			} else if (isOperator(token)) {
				while (!stack.isEmpty()) {
					String peek = stack.peek();
					if (isTopwithHigerPrecedence(peek, token)) {
						output.enqueue(stack.pop());
					} else
						break;
				}
				stack.push(token);
			} else if (isLeftParentheses(token)) {
				stack.push(token);
			} else if (isRightParentheses(token)) {
				boolean isLeftFound = false;
				while (!stack.isEmpty()) {
					String top = stack.pop();
					if (!isLeftParentheses(top)) {
						output.enqueue(top);
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
			String top = stack.pop();
			if (isLeftParentheses(top) || isRightParentheses(top)) {
				throw new RuntimeException("Parentheses are not balanced");
			}
			output.enqueue(top);
		}

		Iterator<String> itr = output.iterator();

		StringBuilder sb = new StringBuilder();
		while (itr.hasNext()) {
			sb.append(itr.next());
			sb.append(" ");
		}

		return sb.toString();
	}

	public static int postFixEvaluation(String expr) {

		Stack<Integer> stack = new LinkedListStack<>();
		StringTokenizer st = new StringTokenizer(expr, " ");
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (isNumber(token)) {
				stack.push(Integer.valueOf(token));
			} else if (isOperator(token)) {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int result = operatorsMap.get(token).evaluate(op1, op2);
				stack.push(result);
			}
		}

		return stack.pop();

	}

	private static boolean isTopwithHigerPrecedence(String peek, String token) {
		if (!isOperator(peek))
			return false;

		Operators op1 = operatorsMap.get(peek);
		Operators op2 = operatorsMap.get(token);

		return op2.getAssociativity() == LEFT_ASSOCIATIVITY && op1.getPrecedence() >= op2.getPrecedence() || op1.getPrecedence() >= op2.getPrecedence();

	}

	private static boolean isRightParentheses(String token) {
		return token.equals(")");
	}

	private static boolean isLeftParentheses(String token) {
		return token.equals("(");
	}

	private static boolean isOperator(String token) {
		return operatorsMap.containsKey(token);
	}

	private static boolean isNumber(String token) {
		return token.matches("\\d+");
	}

	public static void main(String[] args) {
		String s = "3 + 5 * 6 - 7 * ( 8 + 5 )";
		System.out.println(s+ " InFix To PostFix " + inFixToPostFix(s));
		System.out.println(s+ " PostFix evalution " + postFixEvaluation(inFixToPostFix(s)));

	}

}
