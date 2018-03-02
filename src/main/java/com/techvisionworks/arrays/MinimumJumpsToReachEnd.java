/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class MinimumJumpsToReachEnd {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {2,3,1,1,2,4,2,0,1,1};
		int[] temp = array.clone();
		int stepCount = 0;
		for(int i = 1 ; i <array.length;i++) {
			if(temp[i] > temp[i-1])
				stepCount++;
			else
				temp[i] = temp[i-1]-1;
		}
		System.out.println("stepCount is..."+stepCount+1);
	}

}
