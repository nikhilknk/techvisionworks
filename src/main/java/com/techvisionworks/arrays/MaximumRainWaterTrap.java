package com.techvisionworks.arrays;

public class MaximumRainWaterTrap {

	public static void main(String[] args) {
		int[] array = {2,0,2};
		int low=0,high=array.length-1;
		int leftMax=low,rightMax=high;
		int result=0;
		while(low<=high) {
			if(array[low] < array[high]) {
				if(array[low]<array[leftMax]) {
					result+=array[leftMax]-array[low];
					low++;
				}else {
					array[leftMax] = array[low];
					low++;
				}
			}
			else {
				if(array[high]<array[rightMax]) {
					result+=array[rightMax]-array[high];
					high--;
				}else {
					array[rightMax] = array[high];
					high--;
				}
			}
		}
		System.out.println(result);
	}

}
