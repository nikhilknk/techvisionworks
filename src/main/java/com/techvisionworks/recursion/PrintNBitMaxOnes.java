/**
 * 
 */
package com.techvisionworks.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nikhil.k
 *
 */
public class PrintNBitMaxOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		List<String> strList = new ArrayList<>();
		recur("",0,n,strList);
		strList.forEach(System.out::println);
	}

	private static void recur(String string, int extraOnes, int remainingNum, List<String> strList) {
		if(remainingNum ==0) {
			strList.add(string);
			return;
		}
		
		recur(string+"1", extraOnes+1, remainingNum-1, strList);
			
		if(extraOnes>0)
			recur(string+"0", extraOnes-1, remainingNum-1, strList);
	}

}
