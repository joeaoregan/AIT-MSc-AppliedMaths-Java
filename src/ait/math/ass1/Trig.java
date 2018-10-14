/*
 * Week 1 Assignment
 * Trig 1
 */
package ait.math.ass1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Trig {

	public static void main(String[] args) {
		DecimalFormat twoD = new DecimalFormat("###.##");
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the distance from the object (Meters): ");
		double d = in.nextDouble();
		System.out.print("Enter the LOS angle between ground and top of Object: ");;
		double angle = in.nextDouble();
		double height = d*Math.tan(Math.toRadians(angle));
		System.out.println("Height of object: "+twoD.format(height)+" meters");
	}

}
