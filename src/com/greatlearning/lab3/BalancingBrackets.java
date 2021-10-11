package com.greatlearning.lab3;

import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	
	static boolean checkingBalanceBrackets(String brackets) {
		
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<brackets.length(); i++) {
			char character = brackets.charAt(i);
			if(character == '(' || character == '[' || character == '{') {
				stack.push(character);
				continue;
			}
			if(stack.isEmpty()) {
				return false;
			}
			char localChar;
			localChar = stack.pop();
			switch(character) 
			{
			case '}':
				if(localChar == '(' || localChar == '[')
					return false;
				break;
			case ')':
				if (localChar == '{' || localChar == '[')
					return false;
				break;
			case ']':
				if (localChar == '(' || localChar == '{')
					return false;
				break;
			}
		}
		return stack.isEmpty();

	}
		
		

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your string with brackets ([],{},()): ");
		String brackets = sc.next();
		if(checkingBalanceBrackets(brackets)) {
			System.out.println("Entered expression is balanced");
		} else {
			System.out.println("Entered expression is not balanced or invalid");
		}
		
		sc.close();

	}

}
