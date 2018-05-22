package com.techvision.common;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    static int[] leftRotation(int[] a, int d) {
    	
    	String s = "nikhil.aa";
    	System.out.println(s.replace("aafa", ""));
    	System.out.println(s.replace("nikhil.", ""));
    	
    	int length = a.length;
        while(d>length)
        	d=d-length;
        for (int i = 0; i < d/2; i++) {
        	int temp = a[i];
        	a[i] = a[d-1-i];
        	a[d-1-i] = temp;
		}
        for (int i = d; i < (d+length)/2; i++) {
        	int temp = a[i];
        	a[i] = a[length-1-i+d];
        	a[length-1-i+d] = temp;
		}
        for (int i = 0; i < length/2; i++) {
        	int temp = a[i];
        	a[i] = a[length-1-i];
        	a[length-1-i] = temp;
		}
        return a;
    }

    public static void main(String[] args) {
    	 int[] aa = {1,2,3,4};
    	 int[] result = leftRotation(aa, 2);
    	  /*
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] a = new int[n];
        for(int a_i = 0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
       */
      
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + (i != result.length - 1 ? " " : ""));
        }
        System.out.println("");


       // in.close();
    }
}
