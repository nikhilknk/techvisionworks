/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class LongestPalindromeSubSequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// String string = "GEEKSFORGEEKS";
		 String string = "agbdba";
	        int n = string.length();
	        int[][] matrix = new int[n][n];
	        
	        for(int i = 0;i<n;i++) {
	        	matrix[i][i] = 1;
	        }
	        
	        for(int len = 2;len<=n;len++) {
	        	for(int i=0;i<n-len+1;i++) {
	        		int j = i+len-1;
	        		
	        		if(len==2 && string.charAt(i) == string.charAt(j)) {
	        			matrix[i][j] = 2;
	        		}else if(string.charAt(i) == string.charAt(j)) {
	        			matrix[i][j] = 2 + matrix[i+1][j-1];
	        		}else {
	        			matrix[i][j] = Math.max(matrix[i+1][j], matrix[i][j-1]);
	        		}
	        	}
	        }
	        
	        System.out.println("The lnegth of the lps is "+ matrix[0][n-1]);
	}
	public static int calculateRecursive(char str[],int start,int len){
        if(len == 1){
            return 1;
        }
        if(len ==0){
            return 0;
        }
        for(int index=start;index<len;index++){
			System.out.println("Value at index "+index +" is "+str[index]);
		}

        if(str[start] == str[start+len-1]){
            return 2 + calculateRecursive(str,start+1,len-2);
        }else{
            return Math.max(calculateRecursive(str, start+1, len-1), calculateRecursive(str, start, len-1));
        }
    }
}
