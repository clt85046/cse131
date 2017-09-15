package book.ch1;

import cse131.ArgsProcessor;

/*
 * From Sedgewick, Program 1.2.5, page 33
 */
public class RandomInt {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int N = ap.nextInt("Enter upper bound");
		
		double r = Math.random();  // 0 <= r < 1
		int n = (int) (r*N);
		System.out.println(n);
	}
	
}
