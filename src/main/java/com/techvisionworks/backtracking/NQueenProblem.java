/**
 * 
 */
package com.techvisionworks.backtracking;

import java.util.Arrays;

/**
 * @author nikhil.k
 *
 */
public class NQueenProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4;
		int[][] matrix = new int[n-1][n-1];
		Position[] positions = new Position[n];
		if(recurseFunction(n,positions,0)) {
			System.out.println("has solution");
			Arrays.stream(positions).forEach(x->System.out.println(x.getX()+"~"+x.getY()));
		}else {
			System.out.println("no solution");
		}
	}

	private static boolean recurseFunction(int n, Position[] positions, int row) {
		if(row==n)
			return true;
		int i = 0;
		for(;i<n;i++) {
			if(checkisSafe(positions,row,i))
			{
					positions[row] = new Position(row, i);
					if(recurseFunction(n, positions, row+1))
						return true;
			}
		}
		
		return false;
	}

	private static boolean checkisSafe(Position[] positions, int row, int i) {
		
		for(int k = 0;k<row;k++) {
			Position position = positions[k];
			if(position.getX() == row || position.getY() == i || position.getX()+position.getY() == row+i || position.getX()-position.getY()==row-i)
			{
				return false;
			}
		}
		return true;
	}

}

class Position{
	int x;
	int y;
	public Position(int x, int y) {
		super();
		this.x = x;
		this.y = y;
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
}
