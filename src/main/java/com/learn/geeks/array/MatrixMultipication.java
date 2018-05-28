/**
 * 
 */
package com.learn.geeks.array;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author nkakki
 *
 */
public class MatrixMultipication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char[][] multD = {{'a','b'}, {'c','d'},{'e','f'}};
		mult(new Stack<>(),multD,0);
	}
	public static void mult(Stack left, char[][] rest, int index) {
		if (rest.length == index) {
			System.out.println(left);
			return;
		}

		char[] current = rest[index];
		for(int i = 0; i < current.length; i++) {
			left.push(current[i]);
			mult(left, rest, index + 1);
			left.pop();
		}
	}
}
