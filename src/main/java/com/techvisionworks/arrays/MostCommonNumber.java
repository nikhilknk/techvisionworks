/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class MostCommonNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] num = {1,3,1,2,4,5,1,4,1,1,1};
		int count  = 0;
		int candidate = 0;
		for(int i =0;i<num.length;i++) {
			if(count==0) {
				candidate = num[i];
				count--;
			}else {
				if(candidate == num[i])
					count++;
				else
					count--;
			}
		}
		if(count==0) {
			System.out.println(" no common number");
		}
		int tempCount = 0;
		for(int i =0;i<num.length;i++) {
			if(candidate == num[i])
				tempCount++;
		}
		if(tempCount >= (num.length/2)) System.out.println(" common number "+candidate);
		else System.out.println(" no common number");
	}

}
