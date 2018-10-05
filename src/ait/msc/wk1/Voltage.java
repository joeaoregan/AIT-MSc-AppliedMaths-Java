/*
 * 05/10/2018 
 * Voltage.java
 */
/**
 *
 * @author kfitzgerald
 */
package ait.msc.wk1;

import java.util.Scanner;
import java.text.*;

public class Voltage {
	static DecimalFormat formatter = new DecimalFormat("00.##E0");

	static void Voltage(double Vi, double R, double t, double C) {
		double V = Vi * (1 - Math.exp((-t) / (R * C)));
		// System.out.println("The outputted voltage is "+V+ " Volts");
		FormatOutput("The outputted voltage is ", V, "Volts");
	}

	static void AppliedVoltage(double V, double R, double t, double C) {
		double Vi = V / (1 - Math.exp((-t) / (R * C)));
		System.out.println("The applied voltage is " + Vi + " Volts");
		FormatOutput("The applied voltage is ", Vi, "Volts");
	}

	static void Resistance(double V, double Vi, double t, double C) {
		double R = -t / (C * Math.log(1 - V / Vi));
		FormatOutput("The Resistance is ", R, " ohms");
	}

	static void Capacitance(double V, double Vi, double t, double R) {
		double C = -t / (R * Math.log(1 - V / Vi));
		FormatOutput("The Capacitance is ", C, " F");
	}

	static void Time(double V, double Vi, double C, double R) {
		double t = -R * C * Math.log(1 - V / Vi);
		FormatOutput("The time taken to reach this voltage is ", t, " sec");
	}

	static void FormatOutput(String s1, double d, String s2) {
		System.out.println(s1 + " " + d + " or " + formatter.format(d) + " " + s2);
	}

	static void Simulator(double Vi, double R, double C) {
		double t = 1;
		double V = 0;
		int step = 6;
		int stepT = 1;
		System.out.println("t(usec)\t\tVoltage (V)");
		System.out.println("----------------------------------------");
		for (int i = 0; i < 7; i++) {
			V = Vi * (1 - Math.exp((-t * Math.pow(10d, -step)) / (R * C)));
			System.out.println((stepT) + "\t\t" + V);
			stepT *= 10;
			step--;
		}
	}

	static void printMenu() {
		System.out.println("==============================================");
		System.out.println("Please select one of the following: ");
		System.out.println("Option 1: Calculate Votage");
		System.out.println("Option 2: Calculate Applied Voltage");
		System.out.println("Option 3: Calculate Resistance");
		System.out.println("Option 4: Calculate Capacitance");
		System.out.println("Option 5: Calculate Time for a set voltage");
		System.out.println("Option 6: Simulator");
		System.out.println("Option 0: Exit");
		System.out.println("==============================================");
		System.out.print("Enter Option: ");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		double V = 0.00103, Vi = 9, R = 50000, C = 0.00000175, t = 0.00001;
		int option = 0;
		printMenu();
		option = in.nextInt();
		while (option != 0) {
			switch (option) {
			case 1: {
				System.out.println("Enter the following Values");
				System.out.print("Applied Voltage: ");
				Vi = in.nextDouble();
				System.out.print("Resistance: ");
				R = in.nextDouble();
				System.out.print("Capacitance: ");
				C = in.nextDouble();
				System.out.print("Time: ");
				t = in.nextDouble();
				Voltage(Vi, R, t, C);
				break;
			}
			case 2: {
				System.out.println("Enter the following Values");
				System.out.print("Voltage: ");
				V = in.nextDouble();
				System.out.print("Resistance: ");
				R = in.nextDouble();
				System.out.print("Capacitance: ");
				C = in.nextDouble();
				System.out.print("Time: ");
				t = in.nextDouble();
				AppliedVoltage(V, R, t, C);
				break;
			}
			case 3: {
				System.out.println("Enter the following Values");
				System.out.print("Voltage: ");
				V = in.nextDouble();
				System.out.print("Applied Voltage: ");
				Vi = in.nextDouble();
				System.out.print("Capacitance: ");
				C = in.nextDouble();
				System.out.print("Time: ");
				t = in.nextDouble();
				Resistance(V, Vi, t, C);
				break;
			}
			case 4: {
				System.out.println("Enter the following Values");
				System.out.print("Voltage: ");
				V = in.nextDouble();
				System.out.print("Applied Voltage: ");
				Vi = in.nextDouble();
				System.out.print("Resistance: ");
				R = in.nextDouble();
				System.out.print("Time: ");
				t = in.nextDouble();
				Capacitance(V, Vi, t, R);
				break;
			}
			case 5: {
				System.out.println("Enter the following Values");
				System.out.print("Voltage: ");
				V = in.nextDouble();
				System.out.print("Applied Voltage: ");
				Vi = in.nextDouble();
				System.out.print("Resistance: ");
				R = in.nextDouble();
				System.out.print("Capacitance: ");
				C = in.nextDouble();
				Time(V, Vi, C, R);
				break;
			}
			case 6: {
				System.out.println("To run the sumulator please enter the following: ");
				System.out.print("Applied Voltage: ");
				Vi = in.nextDouble();
				System.out.print("Resistance: ");
				R = in.nextDouble();
				System.out.print("Capacitance: ");
				C = in.nextDouble();
				Simulator(Vi, R, C);
				break;
			}
			case 0:
				break;
			default: {
				System.out.println("Not a option, Please slect again.");
				break;
			}
			}
			printMenu();
			option = in.nextInt();
		}
	}
}