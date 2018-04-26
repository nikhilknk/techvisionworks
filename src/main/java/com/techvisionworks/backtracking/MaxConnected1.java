package com.techvisionworks.backtracking;

public class MaxConnected1 {
	static int max= 0;

	public static void main(String[] args) {
		int M[][]=  new int[][] {
			{1, 1, 0, 0, 0},
			{0, 1, 0, 0, 1},
			{1, 0, 0, 1, 1},
			{0, 0, 1, 0, 0},
			{1, 0, 1, 0, 1}
		};

	boolean[][] visited = new boolean[M.length][M[0].length];

	for(int i = 0;i < M.length;i++) {
		for(int j = 0; j<M[0].length;j++) {
			
			if(M[i][j] == 1 && !visited[i][j]) {
				visited[i][j] =true;
				getMax(M,i,j,visited,0);
			}
		}
	}
	System.out.println(max);
}

	private static void getMax(int[][] M, int i, int j,boolean[][] visited,int count) {
		 int x[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
	        int y[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};
	        count++;
	        max = Math.max(max, count);
	        for(int k = 0;k<8;k++) {
	        	if(isSafe(M,i+x[k],j+y[k],visited) && M[i+x[k]][j+y[k]] == 1)
	        	{
	        		visited[i+x[k]][j+y[k]] =true;
	        		getMax(M, i+x[k], j+y[k], visited,count);
	        	}
	        }
	}

	private static boolean isSafe(int[][] M, int i, int j, boolean[][] visited) {
		if(i>= 0 && j>= 0 && i<M.length && j<M[0].length && !visited[i][j] ) return true;
		return false;
	}
}
