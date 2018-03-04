/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class LargestSquareOf1sMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = {{1,1,0,1,0},{0,1,1,1,0},{1,1,1,1,0},{0,1,1,1,1}};

		int[][] matrix = new int[input.length][input[0].length];
		for(int i = 0; i<input[0].length;i++)
			matrix[0][i] = matrix[0][i] == 1 ? 1 : 0;
		for(int i = 0; i<input.length;i++)
			matrix[i][0] = matrix[i][0] == 1 ? 1 : 0;

		for(int i = 1; i<input.length;i++) {
			for(int j = 1;j<input[0].length;j++) {
				if(input[i][j] == 0 )
					matrix[i][j] = 0;
				else {
					matrix[i][j] = getMin(matrix[i-1][j-1],matrix[i-1][j],matrix[i][j-1])+1;
				}
			}
		}
		System.out.println(matrix);
	}

	private static int getMin(int i, int j, int k) {
		int tempMin = Math.min(i, j);
		return Math.min(tempMin, k);
	}

}
