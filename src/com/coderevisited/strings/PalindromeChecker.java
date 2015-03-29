package com.coderevisited.strings;


/**
 * This program that reads in a sequence of strings and checks whether it constitutes
 * a palindrome. Ignore punctuation and spaces and case. for example "A MAN, A PLAN, A CANAL
 * - PANAMA" is a valid palindrome
 * 
 * @author sureshsajja
 * 
 */
public class PalindromeChecker {
	
	private static char[] ignoredChars = new char[]{',',' ','.', '-'};
	
	public static boolean checkIfPalindrome(String s){
		s = s.toUpperCase();
		for(int i = 0, j = s.length()-1; i < j; i++,j--){
			char c1 = s.charAt(i);
			while(canIgnore(c1)){
				c1 = s.charAt(++i);
			}
			
			char c2 = s.charAt(j);
			while(canIgnore(c2)){
				c2 = s.charAt(--j);
			}
			
			if(c1 != c2)
				return false;
		}
		return true;
	}

	private static boolean canIgnore(char c1) {
		for(char c : ignoredChars){
			if(c == c1)
				return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		String s = "A MAN, A PLAN, A CANAL - PANAMA";
		System.out.println(s + " is palinrome? "+checkIfPalindrome(s));
	}

}
