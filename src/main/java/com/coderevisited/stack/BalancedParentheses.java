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
 * @author sureshsajja
 * 
 */
public class BalancedParentheses {


	public static void main(String[] args) {

		String parentheses = "({[(]})";
		boolean isBalanced = checkforBalance(parentheses);
		if (isBalanced)
			System.out.println("Parentheses " + parentheses + " is  balanced");
		else
			System.out.println("Parentheses " + parentheses
					+ " is not balanced");

	}


	private static boolean checkforBalance(String parentheses) {
		Stack<Character> stack = new ResizableArrayStack<>(10);
		char[] array = parentheses.toCharArray();
		for (char c : array) {
			if (c == '(' || c == '{' || c == '[') {
				stack.push(c);
			} else if (c == ')') {
				if(stack.isEmpty())
					return false;
				char pop = stack.pop();
				if (pop != '(')
					return false;
			} else if (c == '}') {
				if(stack.isEmpty())
					return false;
				char pop = stack.pop();
				if (pop != '{')
					return false;
			}else if (c == ']') {
				if(stack.isEmpty())
					return false;
				char pop = stack.pop();
				if (pop != '[')
					return false;
			}

		}
		return stack.isEmpty();
	}

}
