package section22;

import java.time.Month;

/**
 * Program demonstrates switch as an expression. Enhanced switched got release
 * in Java 14
 */
public class SwitchExpression {

	public static void main(String[] abc) {
		switchStatement();
		switchExpression();
		yieldSwitchExpression();
		switchVoidType();
		switchExhaustive();
	}

	/**
	 * Simple switch statement example
	 */
	private static void switchStatement() {
		String month = "AUGUST";
		int year = 2025;
		int days = 0;
		switch (month) {
		case "APRIL":
		case "JUNE":
		case "SEPTEMBER":
		case "NOVEMBER":
			days = 30;
			break;
		case "FEBRUARY":
			days = year % 4 == 0 ? 29 : 28;
			break;
		default:
			days = 31;
		}
		System.out.println("Days in a month of " + month + ": " + days);
	}

	/**
	 * Enhanced switch statement i.e. switch expression example. Below is for single
	 * line switch expression
	 */
	private static void switchExpression() {
		String month = "FEBRUARY";
		int year = 2025;
		int days = switch (month) { // switch treated as an expression
		case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> 30; // multiple case labels are allowed
		case "FEBRUARY" -> year % 4 == 0 ? 29 : 28;
		default -> 31; // break is replaced by arrow and value
		};
		System.out.println("Days in a month of " + month + ": " + days);
	}

	/**
	 * Enhanced switch statement i.e. switch expression example. To work with
	 * multiple line for cases, yield can be used.
	 */
	private static void yieldSwitchExpression() {
		String month = "FEBRUARY";
		int year = 2024;
		int days = switch (month) { // switch treated as an expression
		case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> 30; // multiple case labels are allowed
		case "FEBRUARY" -> {
			if (year % 4 == 0) {
				yield 29;
			} else {
				yield 28;
			}
		}
		default -> 31; // break is replaced by arrow and value
		};
		System.out.println("Days in a month of " + month + ": " + days);
	}

	/**
	 * Switch expression with no return type
	 */
	private static void switchVoidType() {
		int year = 2024;
		// yield is use to return data, for void type it is not required
		switch ("APRIL") { // switch treated as an expression
		case "APRIL", "JUNE", "SEPTEMBER", "NOVEMBER" -> System.out.println("Days in a month: " + 30);
		case "FEBRUARY" -> {
			if (year % 4 == 0) {
				System.out.println("Days in a month: " + 29);
			} else {
				System.out.println("Days in a month: " + 28);
			}
		}
		default -> System.out.println("Days in a month: " + 31); // break is replaced by arrow and value
		};
	}

	/**
	 * Exhaustive nature of switch means add default or cover all the possible cases
	 */
	private static void switchExhaustive() {
		Month month = Month.FEBRUARY;
		int year = 2025;
		int days = switch (month) { // switch treated as an expression
		case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30; // multiple case labels are allowed
		case FEBRUARY -> {
			if (year % 4 == 0) {
				yield 29;
			} else {
				yield 28;
			}
		}
//		default -> 31; // since default is commented all cases must be handled
		case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
		};
		System.out.println("Days in a month of " + month + ": " + days);
	}
}
