/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class NumberOfBinarySearchTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 6;
		int[] T = new int[n+1];
		T[0] = 1;
		T[1] = 1;
		T[2] = 2;
		T[3] = 5;
		for (int i = 4; i < T.length; i++) {
			
			for (int j = 0; j < i; j++) {
				T[i] += T[i-1-j]*T[j];	
			}
		}
				
		System.out.println("result is "+T[n]);
 	}

}
