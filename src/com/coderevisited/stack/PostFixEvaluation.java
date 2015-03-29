package com.coderevisited.stack;

import java.util.StringTokenizer;

/**
 * 
 * @author sureshsajja
 * 
 */
public class PostFixEvaluation {

	public static void main(String[] args) {
		String expression = "2 3 + 4 * ";
		Stack<Integer> expr = new LinkedListStack<>();

		StringTokenizer st = new StringTokenizer(expression, " ");
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (isNumber(s)) {
				expr.push(Integer.valueOf(s));
			} else if ("+".equals(s)) {
				Integer result = expr.pop() + expr.pop();
				expr.push(result);
			} else if ("*".equals(s)) {
				Integer result = expr.pop() * expr.pop();
				expr.push(result);
			}
		}

		System.out.println("Value of expression " + expression + " "
				+ expr.pop());

	}

	private static boolean isNumber(String s) {
		return s.matches("\\d+");
	}

}
