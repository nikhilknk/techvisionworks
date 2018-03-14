/**
 * 
 */
package com.techvisionworks.stack;

import java.util.Stack;

/**
 * @author nikhil.k
 *
 */
public class DuplicateParanthesis {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 String str = "(((a+b))+(c+d))";
		 Stack s = new Stack<>();
		 char[] charArray = str.toCharArray();
		 for(char c : charArray)
		 {
			 if(c == ')') {
				 char top = (char) s.peek();
				 if(top == '(')
				 {
					 System.out.println("its duplicate ");
					 break;
				 }
				 
					 while((char) s.peek() != '(') {
						 s.pop();
					 }
					 
					 s.pop();
			 }else {
				 s.push(c);
			 }
		 }
		 System.out.println("its not");
	}

}
