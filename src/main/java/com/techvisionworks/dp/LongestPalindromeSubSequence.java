package com.techvisionworks.dp;

public class LongestPalindromeSubSequence {

	public static void main(String[] args) {
		String str  = "Nihil";
		int[][] matrix = new int[str.length()][str.length()];
		for(int i = 0; i< str.length();i++) {
			matrix[i][i] = 1; 
		}
		
		for(int len = 2; len<=str.length();len++) {
			for(int j = 0;j<str.length()-len+1;j++) {
				int start = j;
				int end = j+len-1;
				if( len ==2 && (str.charAt(start) == str.charAt(end)))
				{
					matrix[start][end] = 2; 
				}else if(str.charAt(start) == str.charAt(end)) {
					matrix[start][end] = matrix[start+1][end-1]+2;
				}else {
					matrix[start][end] = Math.max(matrix[start+1][end],matrix[start][end-1]);
				}
			}
		}
		System.out.println(" max length is "+matrix[0][str.length()-1]);
	}

}
