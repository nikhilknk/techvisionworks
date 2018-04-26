/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class KMPAlgorithm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pattern = "ABABCABAB";
		String txt  = "ABABDABACDABABCABAB";
		int[] lps = new int[pattern.length()];
		for(int i = 0 ;i< lps.length;i++) {
			lps[i] = 0;
		}
		formLPS(pattern,lps);
		int current = 0;
		int currentPattern  = 0;
		while(current < txt.length()) {
			if(txt.charAt(current) == pattern.charAt(currentPattern)) {
				current++;
				currentPattern++;
			}

			if(currentPattern == pattern.length()) {
				System.out.println("found pattern at "+ (current-pattern.length()));
				currentPattern = lps[currentPattern-1];
			}
			else if(current < txt.length() && txt.charAt(current) != pattern.charAt(currentPattern)) {
				if(currentPattern != 0) {
					currentPattern  = lps[currentPattern-1];
				}
				else{
					current++;
				}
			}
		}
		System.out.println(lps.toString());
	}

	private static void formLPS(String pattern, int[] lps) {
		int length = 0;
		int current = 1 ;
		while(current<pattern.length()) {
			if(pattern.charAt(current)==pattern.charAt(length)) {
				length++;
				lps[current]= length;
				current++;
			}else {
				if(length==0) {
					lps[current] = 0;
					current++;
				}else {
					length = lps[length-1];
				}
			}
		}
	}

}
