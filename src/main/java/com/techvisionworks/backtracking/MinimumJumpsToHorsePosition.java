package com.techvisionworks.backtracking;

import java.util.LinkedList;
import java.util.Queue;

import com.techvision.common.KnightPosition;

public class MinimumJumpsToHorsePosition {

	public static void main(String[] args) {
		int knightPos[] = {1, 1};
		int targetPos[] = {30, 30};
		int N = 30;
		 // x and y direction, where a knight can move
	    int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	    int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	    
		Queue<KnightPosition> q = new LinkedList<KnightPosition>();
		q.add(new KnightPosition(knightPos, null, 0));
		boolean[][] visited = new boolean[N+1][N+1];
		visited[knightPos[0]][knightPos[1]] = true;
		
		outer : while(!q.isEmpty()) {
			KnightPosition knightPosition = q.poll();
			for(int i = 0 ; i<8;i++) {
				if(targetPos[0] == knightPosition.getCurrentPos()[0] + dx[i] && 
						targetPos[1] == knightPosition.getCurrentPos()[1]+ dy[i]) {
					System.out.println(" minimum reached " + knightPosition.getCount()+1);
					break outer;
				}
				int newX = knightPosition.getCurrentPos()[0] + dx[i];
				int newY = knightPosition.getCurrentPos()[1]+ dy[i];
				if(isSafe(newX,newY,N,visited))
					{
					visited[knightPosition.getCurrentPos()[0]][knightPosition.getCurrentPos()[1]] = true;
					q.add(new KnightPosition(new int[]{newX,newY},knightPosition.getCurrentPos(), knightPosition.getCount()+1));
					}
				
			}
		}
	}

	private static boolean isSafe(int newX, int newY,int N,boolean[][] visited) {
		if(newX>=1 && newX <= N && newY>=1 && newY <= N && !visited[newX][newY]) return true;
		return false;
	}
	
	
}
