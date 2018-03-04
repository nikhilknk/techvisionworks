/**
 * 
 */
package com.techvision.common;

/**
 * @author nikhil.k
 *
 */

public class BuildingPoint implements Comparable<BuildingPoint>{

	boolean start;
	public boolean isStart() {
		return start;
	}
	public void setStart(boolean start) {
		this.start = start;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	int x;
	int y;
	@Override
	public int compareTo(BuildingPoint buildingPoint) {
		if(this.getX() != buildingPoint.getX())
			return this.getX()-buildingPoint.getX();
		else 
		return (this.start ? - this.getY() : this.getY()) - (buildingPoint.start ? buildingPoint.getY() : -buildingPoint.getY());
	}
	

}
