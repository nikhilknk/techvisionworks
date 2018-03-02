/**
 * 
 */
package com.techvisionworks.dp;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author nikhil.k
 *
 */
public class WeightJobScheduling {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  	Job jobs[] = new Job[6];
	        jobs[0] = new Job(1,3,5);
	        jobs[1] = new Job(2,5,6);
	        jobs[2] = new Job(4,6,5);
	        jobs[3] = new Job(6,7,4);
	        jobs[4] = new Job(5,8,11);
	        jobs[5] = new Job(7,9,2);
	        System.out.println(maximumResult(jobs));
	}

	private static int maximumResult(Job[] jobs) {
		Arrays.asList(jobs).sort(Comparator.comparing(x->x.end));
		int[] result = new int[jobs.length];
		for(int i = 0;i<jobs.length;i++)
			result[i]=jobs[i].profit;
		for(int i =1;i<jobs.length;i++) {
			int max = result[i];
			for(int j = 0;j<i;j++) {
				if(!(jobs[j].end > jobs[i].start) && max < result[j]+jobs[i].profit) {
					if(result[j]+jobs[i].profit>max)
						max = result[j]+jobs[i].profit;
				}
			}
			result[i] = max;
		}
		System.out.println(Arrays.toString(result));
		return Arrays.stream(result).max().getAsInt();
	}

}
class Job{
    int start;
    int end;
    int profit;
    Job(int start,int end,int profit){
        this.start= start;
        this.end = end;
        this.profit= profit;
    }
}
