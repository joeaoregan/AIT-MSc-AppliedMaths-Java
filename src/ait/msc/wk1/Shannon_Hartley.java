/*
 * Joe O'Regan
 * A00258304
 * 04/10/2018
 * 
 * Shannon_Hartley.java
 * 
 * Applied Maths Week1 Revision S18
 */
package ait.msc.wk1;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Shannon_Hartley {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the available Bandwidth in Hz: ");
		double B = in.nextDouble();
		System.out.print("Enter the SNR in dB: ");
		double SNR = in.nextDouble();
		double SN = Math.pow(10d, SNR / 10d);
		double C = B * ((Math.log(1 + SN)) / (Math.log(2)));
		NumberFormat formatter = new DecimalFormat();
		formatter = new DecimalFormat("00.###E0");
		
		System.out.println("Channel Capacity = " + (C) + " bps");
		System.out.println("Channel Capacity = " + formatter.format(C) + " bps");

		in.close();
	}
}
