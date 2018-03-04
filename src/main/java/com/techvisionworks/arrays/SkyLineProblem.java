/**
 * 
 */
package com.techvisionworks.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

import com.techvision.common.BuildingPoint;

/**
 * @author nikhil.k
 *
 */
public class SkyLineProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  int [][] buildings = {{1,3,4},{3,4,4},{2,6,2},{8,11,4}, {7,9,3},{10,11,2}};
		  BuildingPoint[]  buildingPoints = new BuildingPoint[2*buildings.length];
		  for(int index = 0;index<buildings.length;index++) {
			  buildingPoints[index] = new BuildingPoint();
			  buildingPoints[index].setStart(true);
			  buildingPoints[index].setX(buildings[index][0]);
			  buildingPoints[index].setY(buildings[index][2]);
			  
			  buildingPoints[index+1] = new BuildingPoint();
			  buildingPoints[index+1].setStart(false);
			  buildingPoints[index+1].setX(buildings[index][1]);
			  buildingPoints[index+1].setY(buildings[index][2]);
		  }
		  Arrays.sort(buildingPoints);
		  List<int[]> result = new ArrayList<>();
		  TreeMap queue = new TreeMap<>();
		  int maxValue = 0;
		  queue.put(0, 1);
		  
		  for(BuildingPoint buildingPoint : buildingPoints) {/*
			  if(buildingPoint.isStart()) {
				  
				  queue.compute(buildingPoint.getY(), (key,value)->{
					  if(value != null) return value+1;
					  else return 1;
				  });
				  
				  
				 
			  }
			  else {
				  queue.compute(buildingPoint.getY(), (key,value)->{
					  if(value == 1) return null
					  else value-1;
				  });
			  }
			  
			  int currentKey = queue.lastKey();
			  if(currentKey > maxValue) {
				  maxValue = currentKey;
				  result.add(new int[]{buildingPoint.getX(),buildingPoint.getY()});
			  }
		  */}
		  
	}

}
