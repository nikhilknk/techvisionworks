/**
 * 
 */
package com.techvision.common;

/**
 * @author nkakki
 *
 */
public class StrokeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = {1, 3, 2, 1, 2, 1, 5, 3, 3, 4, 2};
				/*A[0]  = 1;
				  A[1]  = 3;
				  A[2]  = 2;
				  A[3]  = 1;
				  A[4]  = 2;
				  A[5]  = 1;
				  A[6]  = 5;
				  A[7]  = 3;
				  A[8]  = 3;
				  A[9]  = 4;
				  A[10] = 2	;*/
				  System.out.println(strokeCount(A));
	}
	static int strokeCount(int[] A)
	{
	    /*int level = 0;
	    int strokes = 0;

	    for(int height = 0 ; height <A.length;height++)
	    {
	        if (height > level)
	        {
	            strokes += height - level;
	            level = height;
	        }
	        else if (height < level)
	        {
	            level = height;
	        }
	        if (strokes > 1000000000)
	            return -1;
	    }
	    return strokes;
	    
	    
*/
		
		int strokesCount = 0;
		  int currStrokeHeight = 0;

		  for (int i = 0; i < A.length; i++) {
		      if (currStrokeHeight < A[i]) {
		          // next building is taller than our current stroke height
		          // add the difference between heights to strokesCount
		          strokesCount += A[i] - currStrokeHeight;

		          // edge case
		          if (strokesCount > 1000000000) {
		            return -1;
		          }
		      }
		      currStrokeHeight = A[i];
		  }

		  return strokesCount;}
}
