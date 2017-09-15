package lab5;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

/**
 * A test suite for all of the functions in CSE131 lab 5.
 * @author dshook and ron cytron
 *
 */
public class Lab5Tester {

	private Random random = new Random(0);
	
	/**
	 * This method tests the sumDownBy2 function using randomly generated input.
	 */
	@Test
	public void testSumDownBy2() {
		
		//test a couple special cases first
		if(Lab5Methods.sumDownBy2(0) != 0)
		{
			printError("sumDownBy2 error when n = 0: Check to ensure that you cover all cases for n >= 0", 0, Lab5Methods.sumDownBy2(0));
		}
		assertEquals(0, Lab5Methods.sumDownBy2(0));
				
		//generate some random input
		for(int i = 0; i < 100; i++)
		{
			int n = random.nextInt(i + 1);// n >= 0
			int sum = 0;
			int calcSum = Lab5Methods.sumDownBy2(n);
			int nCopy = n;
			
			//calculate correct answer
			while(n >= 0)
			{
				sum += n;
				n -= 2;
			}
			
			//error
			if(sum != calcSum)
			{
				printError("sumDownBy2 error for n = " + nCopy + ": Ensure that you are handling the proper base case (n should always be >= 0)\nand that the arithmetic is being performed properly (sum of positive integers n + n-2 + n -4 + ...)", sum, calcSum);
			}
			assertEquals(sum, calcSum);
		}
	}
	
	/**
	 * Tests the harmonicSum method using randomly generated input.
	 */
	@Test
	public void testHarmonicSum() {
		
		//generate some random input
		for(int i = 0; i < 100; i++)
		{
			int n = random.nextInt(i + 1) + 1; //n > 0
			
			double calcSum = Lab5Methods.harmonicSum(n);
			double sum = 0;
			int nCopy = n;
			
			//calculate harmonic sum
			while(n > 0)
			{
				sum = sum + (1.0 / n);
				n--;
			}
			
			//error
			if(calcSum + .01 < sum || calcSum - .01 > sum)
			{
				printError("harmonicSum error for n = " + nCopy + ": Ensure that you are handling the proper base case (n should always be >= 1)\n and that the computation is being performed properly (sum of 1 + 1/2 + 1/3 + ... + 1/n)", sum, calcSum);
			}
			assertEquals(sum, calcSum, .01);
		}
	}
	
	/**
	 * Tests the geometricSum method using randomly generated input.
	 */
	@Test
	public void testGeometricSum() {
		
		//generate some random input
		for(int i = 0; i < 100; i++)
		{
			int k = random.nextInt(i + 1);//k >= 0
			
			double calcSum = Lab5Methods.geometricSum(k);
			double sum = 0;
			
			int kCopy = k;
			
			//calculate geometric sum
			while(k >= 0)
			{
				sum += (1 / Math.pow(2, k));
				k--;
			}
			
			//error
			if(calcSum + .01 < sum || calcSum - .01 > sum)
			{
				printError("geometricSum error for k = " + kCopy + ": Ensure that you are handling the base case properly (k should always be >= 0)\n and that you are performing the computation correctly (sum of 1 + 1/2 + 1/4 + ... + 1/(2^k))", sum, calcSum);
			}
			assertEquals(sum, calcSum, .01);
		}
	}
	
	private void checkMult(int j, int k, int calcProduct) {
		int product = j * k;//actual product
		
		//error
		if(product != calcProduct)
		{
			printError("Mult error for " + j + " * " + k + ": ", product, calcProduct);
		}
		assertEquals(product, calcProduct);
	}
	
	/**
	 * Tests the multPos method using randomly generated input
	 */
	@Test
	public void testMultPos() {
		
		for(int i = 0; i < 100; i++)
		{
			int j = random.nextInt(1000)+1; // j is positive
			int k = random.nextInt(2000)+1; // k is positive
			checkMult(j, k, Lab5Methods.multPos(j,k));
		}
	}
	
	/**
	 * Tests the mult method using randomly generated input
	 */
	@Test
	public void testMultAny() {
		
		for(int i = 0; i < 100; i++)
		{
			int j = random.nextInt((i + 1) * 2) - i; //j can be positive or negative or zero
			int k = random.nextInt((i + 1) * 2) - i; //k can be positive or negative or zero
			checkMult(j,k, Lab5Methods.mult(j,k));
		}
	}
	
	/**
	 * Tests the expt method using randomly generated input
	 */
	@Test
	public void testExpt() {
		
		for(int i = 0; i < 100; i++)
		{
			int n = random.nextInt((i + 1) * 2) - i;//n can be positive or negative
			int k = random.nextInt(i + 1);//k >= 0
			
			if (n==0 && k==0) continue;
			
			int calcExpt = Lab5Methods.expt(n, k);
			int expt = 1;
			
			//calculate exponential
			if(k > 0)
			{
				expt = n;
			}
				
			for(int j = 0; j < k - 1; j++)
			{
				expt = expt * n;
			}
			
			//error
			if(expt != calcExpt)
			{
				printError("Expt error when n = " + n + ", and k = " + k + ": Ensure you have the proper base case(s) (k = 0? k = 1?)\n and that you are performing the computation correctly (n^k).", expt, calcExpt);
			}
			assertEquals(expt, calcExpt);
		}
		
	}
	
		
	/**
	 * Prints an error message when a comparison between integers fails
	 * @param msg - the error message
	 * @param expected - expected int value
	 * @param actual - actual int value
	 */
	private void printError(String msg, int expected, int actual)
	{
		System.out.println(msg);
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + actual);
	}
	
	/**
	 * Prints an error message when a comparison between doubles fails
	 * @param msg - the error message
	 * @param expected - expected double value
	 * @param actual = actual double value
	 */
	private void printError(String msg, double expected, double actual)
	{
		System.out.println(msg);
		System.out.println("Expected: " + expected);
		System.out.println("Actual: " + actual);
	}
}
