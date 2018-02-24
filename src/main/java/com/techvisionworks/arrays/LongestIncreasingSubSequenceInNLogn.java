package com.techvisionworks.arrays;

public class LongestIncreasingSubSequenceInNLogn {

	public static void main(String[] args) {
		int[] array = {3,4,-1,0,6,2,3};
		int[] T = new int[array.length];
		int[] R = new int[array.length];
		
		for(int i = 0;i<array.length;i++)
			R[i] = -1;
		
		T[0] = 0;
		int length = 0;
		for(int i =0;i<array.length;i++) {
			if(array[T[0]]>array[i])
			{
				T[0] = i;
			}else if(array[T[length+1]]>array[i]) {
				T[length+1] = i;
				R[i] = T[length-1];
						length++;				
			}else {
				int pos = ceilIndex(array, T, T.length, array[i]);
				T[pos] = i;
				R[i] = T[pos-1]; 
			}
		}
		System.out.println("max length is "+length+1);
		int index = T[length];
		while(index != -1) {
			System.out.println(array[index]);
			index  = R[index];
		}
	}
	
	/**
     * Returns index in T for ceiling of s
     */
    private static int ceilIndex(int input[], int T[], int end, int s){
        int start = 0;
        int middle;
        int len = end;
        while(start <= end){
            middle = (start + end)/2;
            if(middle < len && input[T[middle]] < s && s <= input[T[middle+1]]){
                return middle+1;
            }else if(input[T[middle]] < s){
                start = middle+1;
            }else{
                end = middle-1;
            }
        }
        return -1;
    }

}
