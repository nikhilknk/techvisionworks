package com.techvisionworks.misc;

public class MatrixRotation {
public static void main(String[] args) {
	int arr[][]={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};  
	
	//printMatrix(arr);
	rotateAntiClockWise(arr,1);
}

private static void rotateAntiClockWise(int[][] arr, int rotateCount) {
	for(int p = 0;p<rotateCount;p++) {
		
		int prev = 0;
		int bottomRow=arr.length;
		int bottomCol=arr[0].length;
		int topRow = 0;
		int topCol=0;
		
		while(topRow<bottomRow && topCol < bottomCol) {
			
			prev = arr[topRow][topCol];
			//Top left 
			for(int i = topCol+1;i<bottomCol;i++) {
				arr[topRow][i-1] = arr[topRow][i];
			}
			topRow++;
			//Side Down
			arr[topRow][topCol] = prev;
			for(int i = topRow+1;i<bottomRow;i++) {
				arr[i][topCol] = arr[i-1][topCol];
			}
			prev = arr[bottomRow][topCol];
			
//bottom right
			
			/*for(int i = topCol;i<bottomCol;i++) {
				arr[bottomRow][i+1] = arr[bottomRow][i];
			}
			arr[topRow+1][topCol] = prev;
			prev = arr[bottomRow][topCol];*/
			
			
		}
		
		printMatrix(arr);
		
	}
}

private static void printMatrix(int[][] arr) {
	for(int i = 0;i<arr.length;i++) {
		for(int j = 0;j<arr[0].length;j++) {
			System.out.print(arr[i][j]+" ");
		}
		System.out.println("");
	}
}
}
