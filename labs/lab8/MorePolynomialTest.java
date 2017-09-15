package lab8;

import org.junit.Test;
import java.util.Random;

import junit.framework.TestCase;

/**
 * A test suite for CSE131 lab 6, featuring the Polynomial class
 * @author dshook
 *
 */
public class MorePolynomialTest extends TestCase {
	
	private Polynomial p2 = synthPoly(new double[] {  7,  5, -2,  5});
	private Random random = new Random();
	private final int REPS = 100;

	/**
	 * Helper method to generate a Polynomial from an array of doubles.
	 * @param coeffs
	 * @return
	 */
	private Polynomial synthPoly(double[] coeffs) {
		Polynomial ans = new Polynomial();
		for (double d : coeffs) {
			ans.addTerm(d);
		}
		return ans;
	}

	/**
	 * Tests the polynomial sum method using randomly generated input.
	 */
	@Test
	public void testSum() {
		
		for (int i=0; i < REPS; ++i) {
			// Cook up two polynomials of random degree (but at least 1) and with
			//   random coefficients
			double [] coeffs1 = genRandomCoeffs(random.nextInt(7)+1);
			double [] coeffs2 = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs1);
			Polynomial p2 = synthPoly(coeffs2);
			
			// Compute the sum and the derivative of the sum here
			Polynomial sum = new Polynomial();
			for (int j=0; j < Math.max(coeffs1.length, coeffs2.length); ++j) {
				// Sum of this term
				double sTerm = 0;
				if (j < coeffs1.length) sTerm = sTerm + coeffs1[j];
				if (j < coeffs2.length) sTerm = sTerm + coeffs2[j];
				
				sum.addTerm(sTerm);
			}
			if(sum.toString().compareTo(p1.sum(p2).toString()) != 0)
			{
				printError("Error when adding: (" + p1.toString() + ") + (" + p2.toString() + "): Make sure that only terms of the same degree are being added. Think about the case when the polynomials being added don't have the same amount of terms.", sum, p1.sum(p2));
			}
			assertEquals(sum, p1.sum(p2));
		}
	}

	/**
	 * Tests the derivative method of the polynomial class using randomly generated inputs
	 */
	@Test
	public void testDeriv() {
		
		for(int i = 0; i < REPS; i ++)
		{
			//get a polynomial with random length between 1 and 8
			double [] coeffs = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs);
			Polynomial der = new Polynomial();
			
			for (int j=0; j < coeffs.length; ++j) {
				if (j > 0) der.addTerm(coeffs[j]*j);
			}
			if(der.toString().compareTo(p1.derivative().toString()) != 0)
			{
				printError("Error computing derivative of: " + p1.toString() + ": Use the power rule on each term of the polynomial ((exp * coefficient)x^(exp - 1)). Make sure that your order of operations is correct.", der, p1.derivative());
			}
			assertEquals(der, p1.derivative());
		}
	}

	/**
	 * Use randomly generated input to test the eval method of the Polynomial class
	 */
	@Test
	public void testEval() {
		
		for(int i = 0; i < REPS; i++) {
			double [] coeffs = genRandomCoeffs(random.nextInt(7)+1);
			Polynomial p1 = synthPoly(coeffs);
			
			double result = 0;
			double x = random.nextDouble() * 100;
			
			for(int j = 0; j < coeffs.length; j++)
			{
				result = result + coeffs[j] * Math.pow(x, (double)j);
			}
			
			if(p1.evaluate(x) > result + 1 || p1.evaluate(x) < result - 1)
			{

				
				System.out.println("Error evaluating: " + p1.toString() + "This recursive method should be run once for each term in the polynomial. Try passing an iterator to your helper method to track your progress. How do you know when the computation is complete?\nExpected: " + result + "\nActual: " + p1.evaluate(x));
			}
			assertEquals(result, p1.evaluate(x), 1);
		}
	}

	/**
	 * Generates an array of random coefficients
	 * @param num The size of the array
	 * @return an array of random numbers, each in the range 0...99
	 */
	private double[] genRandomCoeffs(int num) {
		double[] ans = new double[num];
		for (int i=0; i < num; ++i) {
			ans[i] = random.nextInt(100);
		}
		return ans;
	}

	private void checkToString(Object o) {
		String s = o.toString();
		assertTrue("You must implement toString for  " + o.getClass(), !s.contains("@"));
	}
	
	@Test
	public void testPrint() {
		checkToString(p2);
		checkToString(new Polynomial());
		System.out.println("p2 is " +p2);
		System.out.println("p2's derivative is " + p2.derivative());
		System.out.println("new poly is " + new Polynomial());
	}

	/**
	 * Prints an error message when any of the above tests fail
	 * @param msg - the error message
	 * @param expected - expected polynomial output
	 * @param actual - actual polynomial output
	 */
	private void printError(String msg, Polynomial expected, Polynomial actual)
	{
		System.out.println(msg);
		System.out.println("Expected: " + expected.toString());
		System.out.println("Actual: " + actual.toString());
	}
}
