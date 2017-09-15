package eyeballs;

import java.awt.Color;

import sedgewick.StdDraw;
import cse131.ArgsProcessor;

public class Eyeballs {
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		StdDraw.picture(0.5, 0.5, "images/ken.jpg");
		int N = ap.nextInt("How many eyeballs?");
	}

}
