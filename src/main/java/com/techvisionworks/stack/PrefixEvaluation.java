/**
 * 
 */
package com.techvisionworks.stack;

import java.util.Stack;

/**
 * @author nikhil.k
 *
 */
public class PrefixEvaluation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[] charArray = {'+','9','*','2','6'};
		Stack stack = new Stack();
		for(int i =  charArray.length-1;i >= 0;i--) {
			if(isOperand(charArray[i])) {
				stack.push((double)(charArray[i] - 48));
			}else {
				double top1 = (double) stack.pop();
				double top2 = (double) stack.pop();
				switch(charArray[i]) {
				case '*' : stack.push(top1*top2);break;
				case '+' : stack.push(top1+top2);break;
				case '-' : stack.push(top1-top2);break;
				case '/' : stack.push(top1/top2);break;
				}
			}
		}
		System.out.println("result is "+stack.pop());
	}

	private static boolean isOperand(char c) {
		 if(c >= 48 && c <= 57)
			    return true;
			    else
			    return false;
	}

}
