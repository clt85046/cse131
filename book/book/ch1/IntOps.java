package book.ch1;
/*
 * From Sedgewick, Program 1.2.2, page 22
 */
import cse131.*;

public class IntOps {
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		int a = ap.nextInt("Value for a?");
		int b = ap.nextInt("Value for b?");
		
		int p = a * b;
		int q = a / b;
		int r = a %b;
		System.out.println(a + " * " + b + " = " + p);
		System.out.println(a + " / " + b + " = " + q);
		System.out.println(a + " % " + b + " = " + r);
		System.out.println(a + " = " + q + " * " + b + " + " + r);
	}

}
