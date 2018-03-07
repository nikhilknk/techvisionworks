/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class ZeroOneKnapsackProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int maxWeight = 7;
		int[] weights = {1,3,4,5};
		int[] values = {1,4,5,7};
		int[][] T = new int[values.length][maxWeight+1];
		
		for(int i = 0;i<T.length;i++)
			T[i][0] = 0;
		
		for(int i = 1;i<T[0].length;i++)
			T[0][i] = values[0];
		
		for(int i = 1;i<T.length;i++) {
			for(int j = 1;j<T[0].length;j++) {
				if(j-weights[i] >= 0)
					T[i][j] = Math.max(values[i]+T[i-1][j-weights[i]], T[i-1][j]);
				else
					T[i][j] = T[i-1][j];
			}
		}
		System.out.println(" max is " + T[weights.length-1][maxWeight]);
 	}

}
