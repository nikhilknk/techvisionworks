/**
 * 
 */
package com.techvisionworks.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections4.map.HashedMap;

/**
 * @author nkakki
 *
 */
public class CombinationOfCharInString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "AABC";
		Set<String> resultList = new HashSet<>();
		char[] charArray= s.toCharArray();
		Map<Character,Integer> charCountMap = new HashedMap<>();
		
		char[] tempChar= new char[s.length()];
		
		for (int i = 0; i < charArray.length; i++) {
			if(charCountMap.containsKey(charArray[i])){
				charCountMap.put(charArray[i], charCountMap.get(charArray[i])+1);
			}else {
				charCountMap.put(charArray[i], 1);
			}
		}
		
		char[] str= new char[charCountMap.size()];
		int[] count= new int[charCountMap.size()];
		int i = 0 ;
		for(Map.Entry<Character,Integer> entry : charCountMap.entrySet()) {
			str[i] = entry.getKey();
			count[i] = entry.getValue();
			i++;
		}
		permitUtil(str,count,charArray,charCountMap,0,resultList,tempChar,0);
		resultList.forEach(System.out::println);
		System.out.println(resultList.size());
	}

	private static void permitUtil(char[] str, int[] count, char[] charArray, Map<Character, Integer> charCountMap,
			int depth, Set<String> resultList, char[] tempChar,int pos) {

		resultList.add(String.valueOf(tempChar).substring(0, depth));
		for(int i = pos ; i < str.length ; i ++) {
			if(count[i] == 0) continue;
			tempChar[depth]  = str[i];
			count[i] = count[i]-1;
			permitUtil(str,count,charArray,charCountMap,depth+1,resultList,tempChar,i);
			count[i]++;
		}
	
	}

}
