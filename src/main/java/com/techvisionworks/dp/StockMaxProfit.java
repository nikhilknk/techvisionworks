/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class StockMaxProfit {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] prices = {3,4,1,0,6,2,3};
		int days = 3;
		int[][] matrix= new int[days+1][prices.length];
 		for(int i = 0 ;i<prices.length;i++) {
 			matrix[0][i] = 0;
 		}
 		for(int i = 0 ;i<=days;i++) {
 			matrix[0][i] = 0;
 		}
		for(int i = 1;i<=days;i++) {
			int maxDiff = -prices[0];
			for(int j = 1;j<prices.length;j++)
			{
				int priceDontDo = matrix[i][j-1];
				int priceIfThey = prices[j]+maxDiff;
				maxDiff = Math.max(maxDiff, matrix[i-1][j]-prices[j]);
				matrix[i][j] = Math.max(priceDontDo, priceIfThey);
			}
				
		}
		System.out.println("max profit is "+matrix[days][prices.length-1]);
	}
}
