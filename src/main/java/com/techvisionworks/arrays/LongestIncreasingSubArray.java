/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class LongestIncreasingSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] array = {3,4,-1,0,6,2,3};
		int maxSoFar= array[0];
		int maxEndingHere= array[0];
		for(int i =1;i<array.length;i++) {
			
			maxEndingHere = maxEndingHere + array[i];
			if(maxEndingHere > maxSoFar) {
				maxSoFar = maxEndingHere;
			}
			
			if(maxEndingHere < 0)
				maxEndingHere = 0;
		}
		
		System.out.println(maxSoFar);
	}

}
