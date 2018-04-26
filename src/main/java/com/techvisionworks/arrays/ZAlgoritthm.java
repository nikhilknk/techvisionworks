/**
 * 
 */
package com.techvisionworks.arrays;

/**
 * @author nikhil.k
 *
 */
public class ZAlgoritthm {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String pattern = "ABABCABAB";
		String txt  = "ABABDABACDABABCABAB";
		String zString = pattern+"$"+txt;
		int[] z = new int[zString.length()];
		formZindex(zString,z);
		for(int i = 0 ; i<z.length;i++) {
			if(z[i] == pattern.length())
				System.out.println("found matching at "+ (i-pattern.length()-1));
		}
	}

	private static void formZindex(String zString, int[] z) {
		z[0] = 0 ;
		int left = 0;
				int right = 0;
		for(int i = 1 ; i<zString.length();i++) {
			if(i>right) {
				left = i;
				right = i;
				while(right < zString.length() && zString.charAt(right) == zString.charAt(right-left)) {
					right++;
				}
				z[i] = right-left;
				right--;
			}else {
				int k1 = i -left;
				if(z[k1] < right-i+1) {
					z[i] = z[k1];
				}else {
					left = i;
					while(right < zString.length() && zString.charAt(right) == zString.charAt(right-left)) {
						right++;
					}
					z[i] = right-left;
					right--;
					
				}
			}
		}
	}

}
