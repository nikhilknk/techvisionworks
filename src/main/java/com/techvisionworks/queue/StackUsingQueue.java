/**
 * 
 */
package com.techvisionworks.queue;

/**
 * @author nikhil.k
 *
 */
public class StackUsingQueue {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NikhilStack nikhilStack = new NikhilStack();
		nikhilStack.pushTest(1);
		nikhilStack.pushTest(2);
		nikhilStack.pushTest(3);
		nikhilStack.popTest();
	    nikhilStack.pushTest(4);
	    nikhilStack.popTest();
	    nikhilStack.popTest();
	    nikhilStack.popTest();
	}

}
