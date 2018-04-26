package com.techvisionworks.backtracking;

public class ProbabilityKnightInsideChessBoard {

	static int N = 8;
	 // x and y direction, where a knight can move
    static int dx[] = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int dy[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	public static void main(String[] args) {
		 // number of steps
        int K = 3;
        System.out.println(findProb(0, 0, K));
	}

	private static int findProb(int startPosX, int startPosY, int k) {
		int[][][] dp = new int[N][N][N];
	    
		for(int i = 0;i<N;i++) {
			for(int j =0;j<N;j++) {
				dp[i][j][0] = 1;
			}
		}
		
		for(int step = 1; step <= k;step++) {
			for(int i = 0;i<N;i++) {
				int prob = 0;
				for(int j =0;j<N;j++) {
					for(int pos =0;j<N;j++) {
						int newX = i+dx[pos];
						int newY = j+dy[pos];
						if(isSafe(newX, newY))
							prob += dp[i][j][pos-1]/8;
					}
					dp[i][j][step] = prob;
				}
			}
		}
		return dp[startPosX][startPosY][k];
	}
	
	private static boolean isSafe(int newX, int newY) {
		if(newX>=0 && newX < N && newY>=0 && newY < N) return true;
		return false;
	}

}
