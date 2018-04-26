package com.techvisionworks.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;

public class AllpermutationsOfString {

	public static void main(String[] args) {
		String s = "AABC";
		char[] charArray= s.toCharArray();
		Map<Character,Integer> charCountMap = new HashedMap<>();
		
		List<String> resultList = new ArrayList<>();
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
		permitUtil(str,count,charArray,charCountMap,0,resultList,tempChar);
		resultList.forEach(System.out::println);
	}

	private static void permitUtil(char[] str, int[] count, char[] charArray, Map<Character, Integer> charCountMap,
			int depth, List<String> resultList, char[] tempChar) {
		if(depth == charArray.length) {
			resultList.add(Arrays.toString(tempChar));
			return;
		}
		for(int i = 0 ; i < str.length ; i ++) {
			if(count[i] == 0) continue;
			tempChar[depth]  = str[i];
			count[i] = count[i]-1;
			permitUtil(str,count,charArray,charCountMap,depth+1,resultList,tempChar);
			count[i]++;
		}
	}
}
