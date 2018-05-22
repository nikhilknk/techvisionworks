package com.techvisionworks.dp;

public class LongestPalindromeSubString {

	public static void main(String[] args) {
		String str  = "Nihil";
		boolean[][] matrix = new boolean[str.length()][str.length()];
		int max = 0;
		int startPoint = 0;
		for(int i = 0; i< str.length();i++) {
			matrix[i][i] = true; 
			max =1;
		}
		
		for(int i = 0; i< str.length()-1;i++) {
			if(str.charAt(i) == str.charAt(i+1))
				{
					matrix[i][i+1] = true; 
					startPoint = i;
					max = 2;
				}
		}
		
		for(int len = 3; len<str.length();len++) {
			for(int j = 0;j<str.length()-len;j++) {
				int start = j;
				int end = j+len-1;
				if(str.charAt(start) == str.charAt(end) && matrix[start+1][end-1])
					{
						matrix[start][end] = true;
						if(len > max)
							{
							startPoint = start;
							max = len;
							}
					}
			}
		}
		System.out.println(" max length is "+max+" ~~~ "+str.substring(startPoint, startPoint+max));
	}

}
