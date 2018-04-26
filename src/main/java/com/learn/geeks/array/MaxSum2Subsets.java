package com.learn.geeks.array;

public class MaxSum2Subsets {

	public static void main(String[] args) {
		int[] a= {6,1,4,6,3,2,7,4};
		int k=3;
		int l=2;
		
		System.out.println(findMaxPossibleSum(a, k, l));
		
	}

	private static int findMaxPossibleSum(int[] a, int k, int l) {
		if(k+l > a.length) {
			return -1;
		}
		int res = 0;
		for(int i=0;i<a.length-k;i++) {
			
			int aliceSum = 0;
			for(int j=i;j<i+k;j++) {
				aliceSum = aliceSum+a[j];
			}
			
			int bobSum = Math.max(findMaxSum(a,l,0,i-1), findMaxSum(a,l,i+k,a.length-1));
			res = Math.max(res, aliceSum+bobSum);
		}
		return res;
	}
	
	public static int findMaxSum(int[] arr,int k,int start,int end) {
			if(start+k-1 > end) {
				return -1;
			} else {
				int res = 0;
			    for (int i=start; i<start+k; i++)
			       res += arr[i];
			 
			    int curr_sum = res;
			    for (int i=start+k; i<=end; i++)
			    {
			       curr_sum += arr[i] - arr[i-k];
			       res = Math.max(res, curr_sum);
			    }
			    return res;
			}
		}
}