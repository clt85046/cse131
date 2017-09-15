/**
 * From Sedgewick, Program 1.1.2, page 8
 */
package book.ch1;

import cse131.ArgsProcessor;

public class UseArgument {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		String name = ap.nextString("Enter your name:");
		System.out.print("Hi, ");
		System.out.print(name);
		System.out.println(". How are you?");

	}

}
