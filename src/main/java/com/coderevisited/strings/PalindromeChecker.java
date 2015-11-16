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
