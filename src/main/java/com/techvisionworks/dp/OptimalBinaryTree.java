/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class OptimalBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   int input[] = {10,12,20,35,46};
	        int freq[] = {34,8,50,21,16};
	        
	        System.out.println(minCostRec(input,freq,0,input.length-1,1));
	        int[][] matrix = new int[input.length][input.length];
	        
	        for(int i = 0;i<input.length;i++) {
	        	matrix[i][i] = freq[i];
	        }
	        
	        for(int L=2;L<=input.length;L++) {
	        	for(int i =0;i<=input.length-L;i++) {
	        		int j = i+L-1;
	        		int min = getMinValue(matrix,i,j);
	        		matrix[i][j] = sumFromiToJ(input,i,j)+min;
	        	}
	        }
	        System.out.println(matrix[0][input.length-1]);
	}

	private static int minCostRec(int[] input, int[] freq, int low, int high, int level) {
		if(low>high) return 0;
		int min = Integer.MAX_VALUE;
		for(int i = low;i<=high;i++) {
			int val = minCostRec(input, freq, low, i-1, level+1) + minCostRec(input, freq, i+1, high, level+1)+freq[i]*level;
			if(val<min)
				min = val;
				
		}
		return min;
	}

	private static int getMinValue(int[][] matrix, int i, int j) {
		int min = Integer.MAX_VALUE;
		for(int k = i;k<=j;k++)
		{
			int value = ((k-1<i) ? 0 : matrix[i][k-1]) + ((k+1>j) ?  0 : matrix[k+1][j]);
			if(value<min)
				min = value;
		}
		return min;
	}

	private static int sumFromiToJ(int[] input, int i, int j) {
		int sum = 0;
		for(int k = i;k<=j;k++) {
			sum += input[k];
		}
		return sum;
	}

}
