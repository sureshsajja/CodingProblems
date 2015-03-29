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
