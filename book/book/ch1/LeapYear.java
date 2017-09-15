package book.ch1;

import cse131.ArgsProcessor;
/*
 * From Sedgewick, Program 1.2.4, page 27
 */

public class LeapYear {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int year = ap.nextInt("Enter year:");
		boolean isLeapYear;
		isLeapYear = (year % 4 == 0);
		isLeapYear = isLeapYear && (year % 100 !=0);
		isLeapYear = isLeapYear ||(year % 400 == 0);
		System.out.println(isLeapYear);
	}
	
}
