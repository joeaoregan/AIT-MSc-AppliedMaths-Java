/*
 * 07/10/2018
 * Applied Maths Wk2 Matrices S24
 * RandomMatrix.java
 */
package ait.msc.wk2;

import java.util.Random;
import java.util.Scanner;

public class RandomMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of rows for the Matrix: ");
		int row = sc.nextInt();
		System.out.print("Enter number of columns for the Matrix: ");
		int col = sc.nextInt();
		double average = 0;
		Random randomGenerator = new Random();
		int[][] matrix = new int[row][col];
		for (int r = 0; r<matrix.length;r++) {
			for (int c=0;c<matrix[0].length;c++) {
				matrix[r][c] = randomGenerator.nextInt(100);
				average+=matrix[r][c];
				System.out.print(matrix[r][c]+"  ");				
			}
			System.out.println();
		}
		System.out.println("The average value of the array is " + average/(row*col));
		sc.close();
	}

}
