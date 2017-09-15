package book.ch2;

import cse131.ArgsProcessor;
import sedgewick.StdOut;

/*************************************************************************
 *  Compilation:  javac Newton.java
 *  Execution:    java Newton x0 x1 x2 x3
 *
 *  Compute the square root using Newton's method. Package it
 *  in a static method.
 *
 *  % java Newton 1 2 3 1000000.1 -2 0 -0 NaN Infinity -Infinity
 *  1.0
 *  1.414213562373095
 *  1.7320508075688772
 *  1000.0000499999987
 *  NaN
 *  0.0
 *  -0.0
 *  NaN
 *  Infinity
 *  NaN
 *
 *************************************************************************/

public class Newton {

	// return the square root of c, computed using Newton's method
	public static double sqrt(double c) {
		if (c < 0) return Double.NaN;
		double EPS = 1E-15;
		double t = c;
		while (Math.abs(t - c/t) > EPS*t)
			t = (c/t + t) / 2.0;
		return t;
	}

	// overloaded version in which user specifies the error tolerance EPS
	public static double sqrt(double c, double EPS) {
		if (c < 0) return Double.NaN;
		double t = c;
		while (Math.abs(t - c/t) > EPS*t)
			t = (c/t + t) / 2.0;
		return t;
	}


	// test client
	public static void main(String[] args) {

		ArgsProcessor ar = new ArgsProcessor(args);	
		Double a = ar.nextDouble("For what value do you seek its square root?");
		double x = sqrt(a);
		StdOut.println(x);

	}
}
