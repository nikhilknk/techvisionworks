package com.techvisionworks.string;
// java program to construct a n length
// string with k distinct characters
// such that no two same characters
// are adjacent.
import java.io.*;
 
public class GFG {
     
    // CPP program to find a string of
    // length n and k distinct characters.
    static String findString(int n, int k)
    {
         
        // Initialize result with first k
        // Latin letters
        String res = "";
         
        for (int i = 0; i < k; i++)
            res = res + (char)('a' + i);
     
        // Fill remaining n-k letters by
        // repeating k letters again and 
        // again.
        int count = 0;
         
        for (int i = 0; i < n - k; i++)
        {
            res = res + (char)('a' + count);
            count++;
             
            if (count == k)
                count = 0;
        }
         
        return res;
    }
     
    // Driver code
    static public void main (String[] args)
    {
     
        int n = 5, k = 3;
         
        System.out.println(findString(n, k));
    }
}