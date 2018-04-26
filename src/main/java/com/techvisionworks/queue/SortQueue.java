/**
 * 
 */
package com.techvisionworks.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author nikhil.k
 *
 */
public class SortQueue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(4);
		q.add(34);
		q.add(1);
		q.add(25);
		q.add(7);
		q.add(2);
		
		for(int i = 0;i<q.size();i++) {
			int minPosition = findMinPosition(q,q.size()-1-i);
			addToRear(q, minPosition);
		}
		q.forEach(System.out::println);
	}

	private static void addToRear(Queue<Integer> q, int minPosition) {
		int minValue = 0;
		for(int k = 0 ; k<=q.size();k++) {
			int tempTop = q.poll();
			if(k==minPosition) {
				minValue = tempTop;
			}else {
				q.add(tempTop);
			}
		}
		q.add(minValue);
	}

	private static int findMinPosition(Queue<Integer> q, int i) {
		int minValue = Integer.MAX_VALUE;
		int minIndex = -1;
		for(int k = 0 ;k<=i;k++) {
			int top  = q.poll();
			if(top<minValue) {
				minIndex = k;
				minValue = top;
			}
			q.add(top);
		}
		for(int p = 0;p<q.size()-1-i;p++) {
			int temp = q.poll();
			q.add(temp);
		}
		return minIndex;
	}

}
