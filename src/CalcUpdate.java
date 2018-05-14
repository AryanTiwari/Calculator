import java.text.DecimalFormat;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class CalcUpdate {

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		DecimalFormat df = new DecimalFormat("####,###.##");

		while (true) {
			// Ask what operation
			System.out.println("\nWhat calculation?");
			System.out.println("add, sub, mult, div, exponent, volume of (shape), sa of (shape)");
			System.out.println(
					"For volume or surface area put length or radius, then width then height, if there isnt a value skip it");
			String answer = input.nextLine();
			
			System.out.println("What numbers to use? (separate them with a space)");

			// Putting values into array
			String numbers = input.nextLine();
			String[] numberString = numbers.trim().split("\\s+");
			Double[] numbersCalc = new Double[numberString.length];
			for (int i = 0; i < numberString.length; i++) {
				numbersCalc[i] = Double.parseDouble(numberString[i]);
			}

			// Sum of all
			Double sum = 0.0;
			for (Double i : numbersCalc) {
				sum += i;
			}

			switch (answer) {
			case "add":
				System.out.println(sum);
				break;
			case "sub":
				System.out.println(numbersCalc[0] - numbersCalc[1]);
				break;
			case "mult":
				System.out.println(numbersCalc[0] * numbersCalc[1]);
				break;
			case "div":
				System.out.println(numbersCalc[0] / numbersCalc[1]);
				break;
			case "exponent":
				System.out.println(Math.pow(numbersCalc[0], numbersCalc[1]));
				break;
			case "sa of cube":
				System.out.println(6 * Math.pow(numbersCalc[0], 2));
				break;
			case "sa of rect prism":
				System.out.println(2 * (numbersCalc[0] * numbersCalc[1] + numbersCalc[1] * numbersCalc[2]
						+ numbersCalc[0] * numbersCalc[2]));
				break;
			case "sa of cylinder":
				System.out.println(df.format(
						2 * Math.PI * numbersCalc[0] * numbersCalc[1] + 2 * Math.PI * Math.pow(numbersCalc[0], 2)));
				break;
			case "sa of pyramid":
				System.out.println(Math.pow(numbersCalc[0], 2) + .5 * numbersCalc[0] * 4 * numbersCalc[1]);
				break;
			case "sa of cone":
				System.out.println(df.format(Math.PI * numbersCalc[0]
						* (numbersCalc[0] + Math.sqrt(Math.pow(numbersCalc[1], 2) + Math.pow(numbersCalc[0], 2)))));
				break;
			case "sa of sphere":
				System.out.println(df.format(4 * Math.PI * Math.pow(numbersCalc[0], 2)));
				break;
			case "volume of cube":
				System.out.println(df.format(Math.pow(numbersCalc[0], 3)));
				break;
			case "volume of rect prism":
				System.out.println(df.format(numbersCalc[0] * numbersCalc[1] * numbersCalc[2]));
				break;
			case "volume of cylinder":
				System.out.println(df.format(Math.PI * Math.pow(numbersCalc[0], 2) * numbersCalc[1]));
				break;
			case "volume of pyramid":
				System.out.println(df.format((numbersCalc[0] * numbersCalc[1] * numbersCalc[2]) / 3));
				break;
			case "volume of cone":
				System.out.println(df.format(Math.PI * Math.pow(numbersCalc[0], 2) * (numbersCalc[1] / 3)));
				break;
			case "volume of sphere":
				System.out.println(df.format(4 / 3 * Math.PI * Math.pow(numbersCalc[0], 3)));
				break;
			}
		}
	}
}