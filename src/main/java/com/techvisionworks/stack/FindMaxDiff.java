/**
 * 
 */
package com.techvisionworks.stack;

import java.util.Stack;

/**
 * @author nikhil.k
 *
 */
public class FindMaxDiff {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2, 4, 8, 7, 7, 9, 3};
		
		Stack<Integer> s = new Stack<>();
		int[] ls = new int[array.length];
		int[] rs = new int[array.length];
		
		formMinArray(array, s, ls);
		int[] reversedArray = new int[array.length];
		int j = 0;
		for (int i = array.length -1; i >= 0; i--){
		    reversedArray[j++] = array[i];
		}
		s.clear();
		formMinArray(reversedArray, s, rs);
		int max = Integer.MIN_VALUE;
		for(int i = 0 ;i<array.length;i++) {
			max = Math.max(max, ls[i]-rs[array.length-1-i]);
		}
		System.out.println("max difference is "+max);
		
	}

	private static void formMinArray(int[] array, Stack<Integer> s, int[] ls) {
		for(int i = 0;i<array.length;i++) {
			if(s.isEmpty()) {
				s.push(array[i]);
				ls[i] = 0;
			}
			else if(array[i]>s.peek()) {
				ls[i] = s.peek();
				s.push(array[i]);
			}else {
				int top = s.peek();
				while(top>=array[i]){
					s.pop();
					top  = (s.isEmpty()) ? 0 : s.peek();
				}
				ls[i] = (s.isEmpty()) ? 0 : s.peek();
				s.push(array[i]);
			}
		}
	}

}
