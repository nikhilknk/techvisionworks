/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class EggDropPuzzle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int floors= 100;
		int eggs = 3;
		int[][] matrix = new int[eggs+1][floors+1];
		for(int i = 1;i<=floors;i++)
			matrix[1][i] = i;
		
		for(int i = 2;i<=eggs;i++) {
			for (int j = 1; j <= floors; j++) {
				if(i>=j)
					matrix[i][j] = matrix[i-1][j];
				else{
					int min = Integer.MAX_VALUE;
					for(int k = 1; k <= j; k++)
					{
						int value = 1  + Math.max(matrix[i-1][k-1], matrix[i][j-k]);
						if(value<min)
							min = value; 
					}
					matrix[i][j] = min;
				}
			}
		}
		System.out.println(matrix[eggs][floors]);
	}
}
