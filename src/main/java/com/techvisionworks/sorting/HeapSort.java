/**
 * 
 */
package com.techvisionworks.sorting;

import java.util.Arrays;

/**
 * @author nikhil.k
 *
 */
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int arr[] = {12, 11, 13, 5, 6, 7};
		 sort(arr);
		 Arrays.stream(arr).forEach(x->System.out.println(x));
	}

	private static void sort(int[] arr) {
		int n = arr.length;
		for(int i = n/2-1;i>=0;i--)
			heapify(arr,n,i);
		
		for(int i = n-1;i>=0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapify(arr, i, 0);
		}
	}

	private static void heapify(int[] arr, int n, int i) {
		int largest = i;
		int left = 2*i;
		int right =2*i+1;
			if(left<=n||right<=n) {
				if(arr[left]>arr[right]) {
					if(left<n && arr[largest]< arr[left]) {
						largest = left;
					}
				}else if(right<n && arr[i]< arr[right])
				{
					largest = right;
				}
			}
			if(largest != i) {
				int temp = arr[i];
				arr[i] = arr[largest];
				arr[largest] = temp;
				heapify(arr, n, largest);
			}
	}

}
