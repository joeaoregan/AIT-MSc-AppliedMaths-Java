/*
 * 07/10/2018
 * Applied Maths Wk2 Matrices S25
 * IdentityMatrix.java
 */
package ait.msc.wk2;

import java.util.Scanner;

public class IdentityMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of rows for the Matrix: ");
		int row = sc.nextInt();
		System.out.println("Enter number of cols for the Matrix: ");
		int col = sc.nextInt();
		
		int[][] matrix = new int[row][col];
		for(int r=0;r<matrix.length;r++) {
			for(int c=0;c<matrix[0].length;c++) {
				if(r==c) {
					matrix[r][c]=1;
				} else {
					matrix[r][c]=0;
				}
				System.out.print(matrix[r][c]+"  ");				
			}
			System.out.println();
		}
		sc.close();
	}

}
