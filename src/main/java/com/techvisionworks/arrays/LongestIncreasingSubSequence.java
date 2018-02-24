package com.techvisionworks.arrays;

public class LongestIncreasingSubSequence {

	public static void main(String[] args) {
		int[] array = {3,4,-1,0,6,2,3};
		int[] result = {1,1,1,1,1,1,1};
		
		for(int i = 1 ;i<array.length;i++) {
			for(int j=0;j<i;j++)
			{
				if(array[i]>array[j] && result[i]<result[j]+1)
					result[i] = result[j]+1;
			}
		}
		System.out.println(getMax(result));
	}
	public static int getMax(int[] inputArray){ 
	    int maxValue = inputArray[0]; 
	    for(int i=1;i < inputArray.length;i++){ 
	      if(inputArray[i] > maxValue){ 
	         maxValue = inputArray[i]; 
	      } 
	    } 
	    return maxValue; 
	  }
}
