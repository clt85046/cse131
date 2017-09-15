package book.ch1;

import cse131.ArgsProcessor;
/*
 * From Sedgewick, Program 1.2.3, page 24
 */

public class Quadratic {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		double b = ap.nextDouble("Value for b in the quadratic equation?");
		double c = ap.nextDouble("Value for c in the quadratic equation?");
		
		double discriminant = b*b - 4.0*c;
		double d = Math.sqrt(discriminant);
		System.out.println((-b + d)/2.0);
		System.out.println((-b - d)/2.0);
	}
	
	
}
