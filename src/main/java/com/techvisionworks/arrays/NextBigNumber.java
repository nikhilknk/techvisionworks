/**
 * 
 */
package com.techvisionworks.arrays;

import java.util.Arrays;

/**
 * @author nikhil.k
 *
 */
public class NextBigNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int number = 51428;
		char[] charArray = ("" + number).toCharArray();
		int lastNum = charArray[charArray.length-1];
		int d1Index = -1;
		int d2Index = -1;
		int i = charArray.length-2;
		for(;i>=0;i--) {
			if(charArray[i] < lastNum) {
				d1Index = i;
				break;
			}
		}
		int min = Integer.MAX_VALUE;
		for(int k = i+1;k<charArray.length;k++) {
			if(charArray[k] < min) {
				min = charArray[k];
				d2Index = k;
			}
		}
		
		int temp = charArray[d1Index];
		charArray[d1Index] = charArray[d2Index];
		charArray[d2Index] = (char) temp;
		
		Arrays.sort(charArray, d1Index+1, charArray.length);
		System.out.println(String.valueOf(charArray));
		
	}

}
