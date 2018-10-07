/*
 * Joe O'Regan
 * 07/10/2018
 * 
 * Applied Maths: Assignment 1
 * Trig.java
 */
package ait.msc.wk1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Trig {

	public static void main(String[] args) {
		DecimalFormat twoD = new DecimalFormat("###.##");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the distance from the object (Meters): ");
		double d = sc.nextDouble();
		System.out.print("Enter the LOS angle between ground and top of Object: ");
		double angle = sc.nextDouble();
		double height = d * Math.tan(Math.toRadians(angle));
		System.out.println("Height of object: " + twoD.format(height) + " meters");
		sc.close();
	}

}
