package com.techvision.common;

import java.util.HashSet;
import java.util.Set;

public class whaf {
public static void main(String[] args) {
	int count = 0;
	int a[]= {1,2,3,4,5};
	Set<Integer> set = new HashSet<>();
	int maxSum=0;
	for(int i=0;i<a.length;i++) {
		set.add(a[i]);
		maxSum = maxSum|a[i];
	}
	System.out.println(maxSum);
	for(int i = 0 ;i<a.length;i++) {
		for(int j = i ; j<a.length;j++) {
			if((a[i]|a[j]) == maxSum)
					{
				System.out.println(a[i]+"~"+a[j]);
					count++;
					break;
					}
		}
	}
	System.out.println(count);
}
}
