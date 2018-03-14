package com.techvisionworks.queue;

import java.util.LinkedList;
import java.util.Queue;

public class NikhilStack {
	Queue<Integer> q1 = new LinkedList<>();
	Queue<Integer> q2 = new LinkedList<>();
	
	public void pop() {
		if(q1.size()>1) {
			for(int i = 0;i<q1.size();i++) {q2.add(q1.poll());
			}
		}
		System.out.println(q1.poll());
		Queue<Integer> temp = q1;
		q1 = q2;
		q2 = temp;;
	}

	public void push(int i) {
		q1.add(i);
	}
	
	public void pushTest(int i) {
		q1.add(i);
		int k = q1.size();
		while(k>1) {
			q1.add(q1.remove());
			k--;
		}
	}
	public void popTest() {
		System.out.println(q1.poll());
	}
}
