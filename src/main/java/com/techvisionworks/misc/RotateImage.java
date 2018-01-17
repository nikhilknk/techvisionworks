package com.techvisionworks.misc;

import java.security.Principal;

public class RotateImage {
	public void rotate(int[][] matrix) {
        int length = matrix.length-1;
        int j=0;
        while(j < matrix.length/2){
            for(int i=j; i < length-j; i++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[length-i][j];
                matrix[length-i][j] = matrix[length-j][length-i];
                matrix[length-j][length-i] = matrix[i][length-j];
                matrix[i][length-j] = temp;
            }
            j++;
        }
    }

    public static void print(int arr[][]){
        for(int i=0; i < arr.length; i++){
            for(int j=0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String args[]){

        int matrix[][] = {{1,5,9,13},{2,6,10,14},{3,7,11,15},{4,8,12,16}};
        print(matrix);
        RotateImage ti = new RotateImage();
        ti.rotate(matrix);
        System.out.println("---------------------");
        ti.print(matrix);
    }
}
