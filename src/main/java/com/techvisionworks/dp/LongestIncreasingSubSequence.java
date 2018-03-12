/**
 * 
 */
package com.techvisionworks.dp;

/**
 * @author nikhil.k
 *
 */
public class LongestIncreasingSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] input = {3,4,1,0,6,2,3};
		int[] result = new int[input.length];
		int[] indexes = new int[input.length];
		
		for(int i = 0;i<input.length;i++)
			result[i] = 1;
		
		for(int i = 1;i<input.length;i++) {
			for (int j = 0; j < i; j++) {
				if(input[i] > input[j])
				{
					if(result[i] < result[j]+1)
						{
						result[i] = result[j]+1;
						indexes[i] = result[j];
						}
				}
			}
		}
		System.out.println(" max length is ..."+result[input.length-1]);
	}

}
