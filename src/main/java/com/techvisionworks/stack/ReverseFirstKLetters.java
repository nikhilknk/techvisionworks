/**
 * 
 */
package com.techvisionworks.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author nikhil.k
 *
 */
public class ReverseFirstKLetters {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {10,20,30,40,50,60,70,80,90,100};
		int k = 5;
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0 ; i<array.length; i++)
		{
			queue.add(array[i]);
		}
		
		for(int i = 0 ; i<k ; i++)
		{
			stack.push(queue.peek());
			queue.poll();
		}
		
		while(!stack.isEmpty()) {
			queue.add(stack.pop());
		}
		for(int i = 0 ; i<array.length-k ; i++)
		{
			queue.add(queue.poll());
		}
		queue.forEach(System.out::println);
	}

}
