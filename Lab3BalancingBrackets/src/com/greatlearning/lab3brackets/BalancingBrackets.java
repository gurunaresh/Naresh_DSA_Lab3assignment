package com.greatlearning.lab3brackets;
import java.util.Scanner;
import java.util.Stack;

public class BalancingBrackets {
	static Scanner sc = new Scanner(System.in);
	static boolean result=false;
	Stack<Character> stack = new Stack<Character>();
	
	public boolean findBalance(String str) {
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
//			push the opening brackets to the stack
			if(ch =='{'||ch=='('||ch=='['||ch=='<') {
				stack.push(ch);
			}
//			pop from stack for every closing bracket
			else if(ch=='}'||ch==')'||ch==']'||ch=='>'){
				if(stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty() ? true : false;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the string");
		String expression = sc.nextLine();
		BalancingBrackets bb = new BalancingBrackets();
		result = bb.findBalance(expression);
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.err.println("The entered Strings do not contain Balanced Brackets");
		}
	}

}
