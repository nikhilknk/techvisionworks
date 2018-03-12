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
public class PrintNotConsecutiveOnes {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		List<String> strList = new ArrayList<>();
		recur("0",false,1,n,strList);
		recur("1",true,1,n,strList);
		strList.forEach(System.out::println);
	}

	private static void recur(String string, boolean is1Ending, int current , int n, List<String> strList) {
		if(current==n) { 
			strList.add(string);
			return ;
		}
		
		if(is1Ending)
			recur(string+"0", !is1Ending,current+1, n, strList);
		else{
			recur(string+"1", !is1Ending,current+1, n, strList);
			recur(string+"0", is1Ending,current+1, n, strList);
		}
			
	}

}
