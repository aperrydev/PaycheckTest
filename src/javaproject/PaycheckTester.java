package javaproject;

import java.util.Scanner;

public class PaycheckTester {
	public static void main(String[] args) {
		//Declare all variables
		Scanner scanner = new Scanner(System.in);
		double hrlyRate;
		double week1Hrs;
		int week1Breaks;
		double week2Hrs;
		int week2Breaks;
		
		// Main information questions
		System.out.print("What is your hourly wage?: ");
		hrlyRate = scanner.nextDouble();
		System.out.println("--------------------------------");
		System.out.print("How many hours did you work on Week 1?: ");
		week1Hrs = scanner.nextDouble();
		System.out.println("--------------------------------");
		System.out.print("How many breaks did you take on Week 1?: ");
		week1Breaks = scanner.nextInt();
		System.out.println("--------------------------------");
		System.out.print("How many hours did you work on Week 2?: ");
		week2Hrs = scanner.nextDouble();
		System.out.println("--------------------------------");
		System.out.print("How many breaks did you take on Week 2?: ");
		week2Breaks = scanner.nextInt();
		System.out.println("--------------------------------");
		
		// expected calculation
		double breakTime = (double)(week1Breaks + week2Breaks) * 30 / 60;
		double scheduledHrs = week1Hrs + week2Hrs;
		double paycheckHrs = scheduledHrs - breakTime;
		double expectedAmount = paycheckHrs * hrlyRate;
		System.out.println("You should expect a gross amount of $" + expectedAmount + " in your paycheck");
		System.out.println("--------------------------------");
		
		// real calculation
		System.out.print("How much money was your gross income this check?: ");
		double realAmount = scanner.nextDouble();
		System.out.println("--------------------------------");
		boolean paycheckTest = (expectedAmount > (realAmount - 20)) && (expectedAmount < (realAmount + 20));
		if (paycheckTest) {
			System.out.println("You have received the correct amount of money on your paycheck");
		}
		else {
			System.out.println("You have not received the correct amount of money on your paycheck");
		}
		
	}

}
