package com.techvisionworks.dp;

public class MatrixChainMultipication {

	public static void main(String[] args) {
		int[] array = {2,3,6,4,5};
		int[][] temp = new int[array.length][array.length]; 
		
		for(int i =0;i<array.length;i++){
			temp[i][i] = 0;
		}
		int q=0;
		for(int L=2;L<array.length;L++) {
			for(int i=0;i<array.length-L;i++) {
				int j=i+L;
				temp[i][j]= Integer.MAX_VALUE;
				for(int k = i+1 ; k < j;k++) {
					q = temp[i][k]+temp[k][j]+array[i]*array[k]*array[j];
					if(q<temp[i][j])
						temp[i][j]=q;
				}
			}
			
		}
		System.out.println("value is..."+temp[0][array.length-1]);
		
	}

}
