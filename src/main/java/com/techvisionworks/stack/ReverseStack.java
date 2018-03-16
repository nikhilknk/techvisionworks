/**
 * 
 */
package com.techvisionworks.stack;

import java.util.Stack;

/**
 * @author nikhil.k
 *
 */
public class ReverseStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		reverse(stack);
		System.out.println(stack);
		
	}

	private static void reverse(Stack<Integer> stack) {
		if(stack.isEmpty()) return ;
		int top = stack.pop();
		reverse(stack);
		//stack.push(top);
		insertAtBottom(top,stack);
	}

	private static void insertAtBottom(int top, Stack<Integer> stack) {
		if(stack.isEmpty())
			stack.push(top);
		else {
			int temp  = stack.pop();
			insertAtBottom(top, stack);
			stack.push(temp);
		}
	}

}
