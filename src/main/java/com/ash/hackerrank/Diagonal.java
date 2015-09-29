package com.ash.hackerrank;

import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
		Scanner sc = new Scanner("3 11 2 4 4 5 6 10 8 -12");
		int numberOfLines = sc.nextInt();
    
        int[][] matrix = new int[numberOfLines][numberOfLines];
 
        for(int i = 0; i<numberOfLines; i++){
            for(int j = 0; j < numberOfLines; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        System.out.println(getDifferenceOfDiagonals(matrix));
    }

	private static int getDifferenceOfDiagonals(int[][] matrix) {
		int diagonal1 = 0;
		int diagonal2 = 0;
		for(int i = 0; i<matrix.length; i++){
			diagonal1 += matrix[i][i];
			diagonal2 += matrix[i][matrix.length-i-1];
		}
		return Math.abs(diagonal1 - diagonal2);
	}
}
