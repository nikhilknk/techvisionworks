/**
 * 
 */
package com.techvisionworks.misc;

import java.util.Arrays;

/**
 * @author nikhil.k
 *
 */
public class NutsBoltsProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nuts = {4,1,6,2,5,3};
		int[] bolts = {1,4,3,5,2,6};
		
		matchPairs(nuts,bolts,0,bolts.length-1);
		System.out.println(Arrays.toString(nuts));
		System.out.println(Arrays.toString(bolts));
				
	}
/*
	// Method which works just like quick sort
    private static void matchPairs(char[] nuts, char[] bolts, int low,
                                                              int high)
    {
        if (low < high)
        {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);
 
            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, nuts[pivot]);
 
            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot-1);
            matchPairs(nuts, bolts, pivot+1, high);
        }
    }
 
    // Similar to standard partition method. Here we pass the pivot element
    // too instead of choosing it inside the method.
    private static int partition(char[] arr, int low, int high, char pivot)
    {
        int i = low;
        char temp1, temp2;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot){
                temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
            } else if(arr[j] == pivot){
                temp1 = arr[j];
                arr[j] = arr[high];
                arr[high] = temp1;
                j--;
            }
        }
        temp2 = arr[i];
        arr[i] = arr[high];
        arr[high] = temp2;
 
        // Return the partition index of an array based on the pivot 
        // element of other array.
        return i;
    }
*/    
    
    private static void matchPairs(int[] nuts, int[] bolts, int low, int high) {

		if(low<high) {
			int pivot = partition(nuts,low,high,bolts[high]);
			partition(bolts,low,high,nuts[pivot]);
			matchPairs(nuts, bolts, low, pivot-1);
			matchPairs(nuts, bolts, pivot+1,high);
		}
	}

	private static int partition(int[] arr, int low, int high, int pivot) {
		int j = low;
		for(int i = low;i<high;i++) {
			if(arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}else if(arr[i] == pivot){
				int temp = arr[i];
				arr[i] = arr[high];
				arr[high] = temp;
				i--;
			}
		}
		 int temp2 = arr[j];
	        arr[j] = arr[high];
	        arr[high] = temp2;
		return j;
	}

}
