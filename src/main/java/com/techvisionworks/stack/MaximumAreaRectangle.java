package com.techvisionworks.stack;

import java.util.Stack;

public class MaximumAreaRectangle {

	public static void main(String[] args) {
		int[] array = {2,3,6,4,5};
		int maxArea = -1;
		int area = -1;
		Stack<Integer> stack = new Stack<>();
		int top =-1;
		for(int i=0;i<array.length;) {
			if(stack.isEmpty() || array[stack.peek()]<=array[i])
			{
				stack.push(i++);
			}
			else {
				top = stack.pop();
				area = array[top] * (stack.isEmpty() ? i : (i-stack.peek()-1));
				if(area>maxArea)
					maxArea = area;
			}
		}
		while(!stack.isEmpty()) {
			top = stack.pop();
			area = array[top] * (stack.isEmpty() ? array.length : (array.length-stack.peek()-1));
			if(area>maxArea)
				maxArea = area;}

		System.out.println(maxArea);
	}

}
