

import java.util.Scanner;

public class PaycheckTester {
		
		//Helper Method
		public static double getValidDouble(Scanner scanner, String prompt) {
			while (true) {
				System.out.println("--------------------------------");
				System.out.print(prompt);
				if(scanner.hasNextDouble()) {
					return scanner.nextDouble();
				}
				else {
					System.out.println("Invalid Input. Please enter a number (e.g. 15.75)");
					scanner.next();
				}
				
			}
		}
		
		//Main Method
		public static void main(String[] args) {
		
			Scanner scanner = new Scanner(System.in);
			
			//Main Info Questions
			double hrlyRate = getValidDouble(scanner, "What is your hourly wage?: ");
			double week1Hrs = getValidDouble(scanner, "How many hours did you work on Week 1?: ");
			double week1Breaks = getValidDouble(scanner, "How many breaks did you take on Week 1?: ");
			double week2Hrs = getValidDouble(scanner, "How many hours did you work on Week 2?: ");
			double week2Breaks = getValidDouble(scanner, "How many breaks did you take on Week 2?: ");
		
			
			
			
			//Expected Calculations
			double overtimeRate = hrlyRate * 1.5;
			double breakTime1 = week1Breaks * 30 / 60;
			double breakTime2 = week2Breaks * 30 / 60;
			double totalBreakTime = breakTime1 + breakTime2;
			
			double actualWeek1Hrs = week1Hrs - breakTime1;
			double actualWeek2Hrs = week2Hrs - breakTime2;
			
			//Overtime Variables
			double overtimeWeek1 = 0;
			double overtimeWeek2 = 0;
			double overtimePay1 = 0;
			double overtimePay2 = 0;
			
			//Overtime Check
			if (actualWeek1Hrs > 40) {
				overtimeWeek1 = actualWeek1Hrs - 40;
				overtimePay1 = overtimeWeek1 * overtimeRate;
			}
			
			if (actualWeek2Hrs > 40) {
				overtimeWeek2 = actualWeek2Hrs - 40;
				overtimePay2 = overtimeWeek2 * overtimeRate;
			}
			
			//Final Variables
			double totalOvertime = overtimeWeek1 + overtimeWeek2;
			double normalHrs = (actualWeek1Hrs + actualWeek2Hrs) - totalOvertime;
			double normalPay = normalHrs * hrlyRate;
			double overtimePay = overtimePay1 + overtimePay2;
			double expectedAmount = normalPay + overtimePay;
			
		
			System.out.println("--------------------------------");
			System.out.println("You should expect a gross amount of $" + expectedAmount + " in your paycheck");
		
			// Real Calculation
			double realAmount = getValidDouble(scanner, "How much did you receive for your gross income in this check?: ");
		
			// Test
			boolean paycheckTest = (expectedAmount > (realAmount - 20)) && (expectedAmount < (realAmount + 20));
			if (paycheckTest) {
				System.out.println("--------------------------------");
				System.out.println("You have received the correct amount of money on your paycheck");
			}
			else {
				System.out.println("--------------------------------");
				System.out.println("You have not received the correct amount of money on your paycheck");
			}
			
	}

}	
